package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.businesslogic.ReviewFilter;
import com.lunacinemas.model.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReviewControllerTest {


    @Autowired
    @InjectMocks
    private ReviewController  controller;

    @Mock
    private ReviewFilter businessWare;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testInsertReview(){

        Review incomingReview = new Review();
        incomingReview.setValues("5d4b29169b6b570ae06ee3fb", "3", "Meh, it was alright, wont be watching again.", "Carl");
        ResponseObject responseObject = new ResponseObject();
        when(businessWare.saveReview(incomingReview)).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/insertreview/" + incomingReview.getFilmId() +
                "/"+incomingReview.getRating()+"/"+incomingReview.getUsername(), ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetReviews(){
        ResponseObject responseObject = new ResponseObject();
        when(businessWare.getReviews("5d4b29169b6b570ae06ee3fb")).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getreviews/5d4b29169b6b570ae06ee3fb", ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetReview(){
        ResponseObject responseObject = new ResponseObject();
        when(businessWare.getReview("5d4b29169b6b570ae06ee3fc")).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getreview/5d4b29169b6b570ae06ee3fc", ResponseObject.class))
                .hasSameClassAs(responseObject);
    }
}