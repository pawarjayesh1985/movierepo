package ksubaka.services.movie;

import ksubaka.abstracts.AbstractKsubakaTest;
import ksubaka.client.feign.OmdbApiClient;
import ksubaka.client.feign.TheMovieDBClient;
import ksubaka.constants.KsubakaConstants;
import ksubaka.interfaces.services.IOmdbApiClientService;
import ksubaka.interfaces.services.ITheMovieDBService;
import ksubaka.view.omdb.Movie;
import ksubaka.view.themoviedb.Credits;
import ksubaka.view.themoviedb.Crew;
import ksubaka.view.themoviedb.Result;
import ksubaka.view.themoviedb.TheMovieDb;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by jpawar on 11/9/2020.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfigTest.class)
@PropertySource("classpath:application.properties")
public class MovieServiceTest extends AbstractKsubakaTest {
    private static final String MOVIE_NAME = "Titanic";
    private static final String DIRECTOR = "James Cameron";
    private static final String YEAR = "1997";

    @Autowired
    private MovieService movieService;

    @Autowired
    private IOmdbApiClientService omdbApiClientService;
    @Autowired
    private ITheMovieDBService theMovieDBService;

    @Mock
    private OmdbApiClient omdbApiClient;

    @Mock
    private TheMovieDBClient theMovieDBClient;

    @Before
    public void setup() {
        omdbApiClient = mock(OmdbApiClient.class);
        theMovieDBClient = mock(TheMovieDBClient.class);

        ReflectionTestUtils.setField(this.<IOmdbApiClientService>getTargetObject(omdbApiClientService), "omdbApiClient", omdbApiClient);
        ReflectionTestUtils.setField(this.<ITheMovieDBService>getTargetObject(theMovieDBService), "theMovieDBClient", theMovieDBClient);

    }


    @Test
    public void testOmDbMovie() {
        when(omdbApiClient.getMovieInfo(anyString(), anyString())).thenReturn(prepareMockMovie());
        String movieResult =  movieService.getMovieInfo(KsubakaConstants.OM_DB, MOVIE_NAME);

        assertTrue(movieResult.contains(MOVIE_NAME));
        assertTrue(movieResult.contains(DIRECTOR));
        assertTrue(movieResult.contains(YEAR));

        verify(omdbApiClient, times(1)).getMovieInfo(any(), any());
    }

    @Test
    public void testTheMovieDb() {
        when(theMovieDBClient.getAllMovieInfo(anyString(), anyString())).thenReturn(prepareTheMovieDb());
        when(theMovieDBClient.getMovieCredits(anyInt(), anyString())).thenReturn(prepareCredits());

        String movieResult =  movieService.getMovieInfo(KsubakaConstants.THE_MOVIE_DB, MOVIE_NAME);

        assertTrue(movieResult.contains(MOVIE_NAME));
        assertTrue(movieResult.contains(DIRECTOR));
        assertTrue(movieResult.contains(YEAR));

        verify(theMovieDBClient, times(1)).getAllMovieInfo(any(), any());
        verify(theMovieDBClient, times(1)).getMovieCredits(any(), any());
    }

    public TheMovieDb prepareTheMovieDb() {
        TheMovieDb theMovieDb = new TheMovieDb();
        List<Result> resultList = new ArrayList<>();
        Result result = new Result();
        result.setId(3233);
        result.setTitle(MOVIE_NAME);
        result.setRelease_date("1997-11-18");
        resultList.add(result);
        theMovieDb.setResults(resultList);
        return theMovieDb;
    }

    public Credits prepareCredits() {
        Credits credits = new Credits();

        credits.setId("455");
        Crew crew = new Crew();
        crew.setId(4554);
        crew.setJob("director");
        crew.setName(DIRECTOR);

        List<Crew> crewList = new ArrayList<>();
        crewList.add(crew);
        credits.setCrew(crewList);

        return credits;
    }

    public Movie prepareMockMovie() {
        Movie movie = new Movie();
        movie.setTitle(MOVIE_NAME);
        movie.setDirector(DIRECTOR);
        movie.setYear(YEAR);
        return movie;
    }


}
