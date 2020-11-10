package ksubaka.interfaces.services;

import ksubaka.view.response.MovieResponse;

import java.util.List;

/**
 * Created by jpawar on 11/9/2020.
 */
public interface IOmdbApiClientService {
    List<MovieResponse> getMovieInfo(String movieTitle);
}
