package ksubaka.services.movie;

import ksubaka.constants.KsubakaConstants;
import ksubaka.exceptions.ApiNameUnExpetedException;
import ksubaka.failures.PreDefinedErrorMessage;
import ksubaka.interfaces.services.IOmdbApiClientService;
import ksubaka.services.themoviedb.TheMovieDBService;
import ksubaka.util.JsonUtils;
import ksubaka.view.omdb.MovieResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by jpawar on 11/8/2020.
 */
@Service
public class MovieService {
    private JsonUtils jsonUtil = JsonUtils.getInstance();

    @Autowired
    private IOmdbApiClientService omdbApiClientService;

    @Autowired
    private TheMovieDBService theMovieDBService;

    @Autowired
    private PreDefinedErrorMessage preDefinedErrorMessage;

    public String getMovieInfo(String apiName, String movieTitle) {
        String response = StringUtils.EMPTY;

        if(KsubakaConstants.OM_DB.equalsIgnoreCase(apiName)) {
            response = processOmDbMovieInfo(movieTitle);
        } else if(KsubakaConstants.THE_MOVIE_DB.equalsIgnoreCase(apiName)) {
            response = processTheMovieDb(movieTitle);
        } else {
            throwApiNameNotFoundException(apiName);
        }

        return response;
    }

    public void throwApiNameNotFoundException(String apiName) {
        String response = preDefinedErrorMessage.getAPINameIsInvalidMessage();
        throw new ApiNameUnExpetedException(response);
    }


    public String processTheMovieDb(String movieTitle) {
        List<MovieResponse>  theMovieDBServiceMovieList = theMovieDBService.getMovieInfo(movieTitle);
        return  CollectionUtils.isEmpty(theMovieDBServiceMovieList) ?
                preDefinedErrorMessage.movieNotFoundMessage(movieTitle):
                getMovieResponseAsString(theMovieDBServiceMovieList);



    }
    public String processOmDbMovieInfo(String movieTitle) {
        List<MovieResponse> movieResponseList = omdbApiClientService.getMovieInfo(movieTitle);
        return CollectionUtils.isEmpty(movieResponseList) ?
                preDefinedErrorMessage.movieNotFoundMessage(movieTitle) :
                getMovieResponseAsString(movieResponseList);
    }

    public String getMovieResponseAsString(List<MovieResponse>  movieResponse) {
        return jsonUtil.writeValueAsString(movieResponse);
    }
}
