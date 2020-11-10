package ksubaka.controller;

import ksubaka.services.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jpawar on 11/8/2020.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/fetchMovieInfo", method = RequestMethod.GET)
    public String getMovieInformation(@RequestParam(value = "apiName") String apiName,
                                      @RequestParam(value = "movieTitle") String movieTitle) {
        return movieService.getMovieInfo(apiName, movieTitle);
    }
}
