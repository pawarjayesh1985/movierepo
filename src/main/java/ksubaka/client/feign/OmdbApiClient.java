package ksubaka.client.feign;

import ksubaka.view.omdb.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jpawar on 11/8/2020.
 */
@FeignClient(value = "omdbAPIClient", url = "${om.db.api.client.url}")
public interface OmdbApiClient {

    @GetMapping(value = "/")
    Movie getMovieInfo(@RequestParam("t") String movieTitle, @RequestParam("apikey") String apikey);
}
