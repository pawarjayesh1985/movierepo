package ksubaka.client.feign;

import ksubaka.view.themoviedb.Credits;
import ksubaka.view.themoviedb.TheMovieDb;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jpawar on 11/8/2020.
 */
@FeignClient(value = "theMovieDBClient", url = "${the.movie.db.url}")
public interface TheMovieDBClient {
    @GetMapping(value = "/3/search/movie")
    TheMovieDb getAllMovieInfo(@RequestParam("query") String movieTitle, @RequestParam("api_key") String apikey);

    @GetMapping(value = "/3/movie/{id}/credits")
    Credits getMovieCredits(@PathVariable(value = "id") Integer id, @RequestParam("api_key") String apikey);

}
