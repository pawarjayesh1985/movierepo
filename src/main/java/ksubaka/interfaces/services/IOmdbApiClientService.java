package ksubaka.interfaces.services;

import ksubaka.view.omdb.MovieResponse;

import java.util.List;

/**
 * Created by jpawar on 11/9/2020.
 */
public interface IOmdbApiClientService {
    List<MovieResponse> getMovieInfo(String movieTitle);
}
