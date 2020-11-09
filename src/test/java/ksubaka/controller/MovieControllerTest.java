package ksubaka.controller;

import ksubaka.services.movie.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by jpawar on 11/9/2020.
 */
//TODO: Need to be revisited
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class MovieControllerTest {

    @InjectMocks
    private MovieController movieController;

    @Autowired
    private WebApplicationContext webAppContext;

    @Mock
    private MovieService movieService;

    private MockHttpSession mockSession;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
        MockitoAnnotations.initMocks(this);
        mockSession = new MockHttpSession();
    }

    @Test
    public void testGetMovieInformation() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/movie/fetchMovieInfo")
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .param("apiName", "omdb")
                .param("movieTitle", "avatar")
                .session(mockSession));
        //Verify the results
        resultActions.andExpect(status().isOk());

        //Verify the content of the response
        final MvcResult mvcResult = resultActions.andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        /*String response = JsonUtils.getInstance().getObjectFromResponse(mvcResult.getResponse().getContentAsString(),
                String.class);*/
        assertNotNull(response);
        //assertTrue(mvcResult.isSuccess());
    }
}
