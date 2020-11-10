package ksubaka.services.themoviedb;

import feign.FeignException;
import ksubaka.client.feign.TheMovieDBClient;
import ksubaka.failures.PreDefinedErrorMessage;
import ksubaka.interfaces.services.ITheMovieDBService;
import ksubaka.view.response.MovieResponse;
import ksubaka.view.themoviedb.Credits;
import ksubaka.view.themoviedb.Crew;
import ksubaka.view.themoviedb.Result;
import ksubaka.view.themoviedb.TheMovieDb;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by jpawar on 11/8/2020.
 */
@Service
public class TheMovieDBService implements ITheMovieDBService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TheMovieDBService.class);
    private static final String DIRECTOR = "director";

    @Value("${the.movie.db.api.key}")
    private String theMovieDbApiKey;

    @Autowired
    private PreDefinedErrorMessage preDefinedErrorMessage;

    @Autowired
    private TheMovieDBClient theMovieDBClient;

    public List<MovieResponse> getMovieInfo(String movieTitle) {
        List<MovieResponse> movieResponseList = null;
        try {
            TheMovieDb theMovieDb = theMovieDBClient.getAllMovieInfo(movieTitle, theMovieDbApiKey);
            throwMovieNotFoundExceptionIfAny(theMovieDb, movieTitle);

            List<Result> theMovieDbResults = theMovieDb.getResults();
            movieResponseList = new ArrayList<>();
            for (Result movieResult : theMovieDbResults) {
                MovieResponse movieResponse = new MovieResponse();
                movieResponse.setName(movieResult.getTitle());
                movieResponse.setYear(movieResult.getRelease_date().substring(0,4));
                Credits credits = theMovieDBClient.getMovieCredits(movieResult.getId(), theMovieDbApiKey);
                List<Crew> crews = credits.getCrew();
                for (Crew crew : crews) {
                    if (DIRECTOR.equalsIgnoreCase(crew.getJob())) {
                        movieResponse.setDirector(crew.getName());
                        break;
                    }
                }
                movieResponseList.add(movieResponse);
            }

        } catch (FeignException feignException) {
            LOGGER.error("This is issue while reaching to The Movie DB client for movie {} ", movieTitle);
            LOGGER.error("Issue" , feignException);
        }

       return ListUtils.emptyIfNull(movieResponseList);
    }


    private void throwMovieNotFoundExceptionIfAny(TheMovieDb theMovieDb, String movieTitle) {
        if(Objects.isNull(theMovieDb) || CollectionUtils.isEmpty(theMovieDb.getResults())) {
            preDefinedErrorMessage.movieNotFoundMessage(movieTitle);
        }
    }
}
