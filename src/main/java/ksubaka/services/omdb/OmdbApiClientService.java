package ksubaka.services.omdb;

import feign.FeignException;
import ksubaka.client.feign.OmdbApiClient;
import ksubaka.failures.PreDefinedErrorMessage;
import ksubaka.interfaces.services.IOmdbApiClientService;
import ksubaka.view.omdb.Movie;
import ksubaka.view.response.MovieResponse;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
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
public class OmdbApiClientService implements IOmdbApiClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OmdbApiClientService.class);

    @Value("${om.db.client.api.key}")
    private String omDbClientAPIKey;

    @Autowired
    private OmdbApiClient omdbApiClient;

    @Autowired
    private PreDefinedErrorMessage preDefinedErrorMessage;

    public List<MovieResponse> getMovieInfo(String movieTitle) {
        List<MovieResponse> movieResponseList = null;
        try {
            Movie omdbMovie  = omdbApiClient.getMovieInfo(movieTitle, omDbClientAPIKey);

            throwMovieNotFoundExceptionIfAny(omdbMovie, movieTitle);

            movieResponseList = new ArrayList<>();
            MovieResponse movieResponse = prepareMovieResponse(omdbMovie);
            movieResponseList.add(movieResponse);
        } catch(FeignException feignException) {
            LOGGER.error("This is issue while reaching to OM DB client for movie {} ", movieTitle);
            LOGGER.error("Issue" , feignException);
        }
        return ListUtils.emptyIfNull(movieResponseList);
    }

    private void throwMovieNotFoundExceptionIfAny(Movie omdbMovie, String movieTitle) {
        if(Objects.isNull(omdbMovie) || StringUtils.isBlank(omdbMovie.getTitle())) {
            preDefinedErrorMessage.movieNotFoundMessage(movieTitle);
        }
    }

    private MovieResponse prepareMovieResponse(Movie omdbMovie) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setName(omdbMovie.getTitle());
        movieResponse.setYear(omdbMovie.getYear());
        movieResponse.setDirector(omdbMovie.getDirector());
        return movieResponse;
    }
}
