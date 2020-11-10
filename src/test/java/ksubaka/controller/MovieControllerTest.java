package ksubaka.controller;

import ksubaka.services.movie.MovieService;
import ksubaka.util.JsonUtils;
import ksubaka.view.response.MovieResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jpawar on 11/9/2020.
 */
//TODO: Need to be revisited
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieControllerTest {
    private static final String MOVIE_NAME = "Titanic";
    private static final String DIRECTOR = "James Cameron";
    private static final String YEAR = "1997";


    @InjectMocks
    private MovieController movieController;

    @Mock
    private MovieService movieService;

    private MockHttpSession mockSession;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockSession = new MockHttpSession();
        buildStandaloneMockMvc(movieController);

    }

    protected void buildStandaloneMockMvc(Object... controllers) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controllers)
                .build();
    }

    @Test
    public void testGetMovieInformation() throws Exception {

        when(movieService.getMovieInfo(anyString(), anyString()))
                .thenReturn(JsonUtils.getInstance().writeValueAsString(prepareMockResponse()));

        ResultActions resultActions = mockMvc.perform(get("/movie/fetchMovieInfo")
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .param("apiName", "omdb")
                .param("movieTitle", MOVIE_NAME)
                .session(mockSession));
        //Verify the results
        resultActions.andExpect(status().isOk());

        //Verify the content of the response
        final MvcResult mvcResult = resultActions.andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        assertNotNull(response);
        assertTrue(response.contains(MOVIE_NAME));
        assertTrue(response.contains(DIRECTOR));
        assertTrue(response.contains(YEAR));
    }

    private List<MovieResponse>  prepareMockResponse() {
        List<MovieResponse> movieResponseList = new ArrayList<>();
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setName(MOVIE_NAME);
        movieResponse.setDirector(DIRECTOR);
        movieResponse.setYear(YEAR);
        movieResponseList.add(movieResponse);
        return movieResponseList;
    }
}
