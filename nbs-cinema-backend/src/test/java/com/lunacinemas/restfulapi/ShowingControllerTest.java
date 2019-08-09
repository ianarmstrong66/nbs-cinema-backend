package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.businesslogic.ShowingHandler;
import com.lunacinemas.model.Showing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShowingControllerTest {

    @Autowired
    @InjectMocks
    private ShowingController controller;

    @Mock
    private ShowingHandler businessWare;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private Showing constructShowing(){
        Showing showing = new Showing();

        showing.setFilmId("5d42e0249b6b570b7c9f1509");
        showing.setShowingTime("20:00");
        showing.setDate("09/08/19");
        showing.setSeatsAvailable(15);
        showing.setTotalNumberOfSeats(20);
        showing.setSeatsAvailable(showing.getTotalNumberOfSeats());
        showing.setScreenType("Standard");
        return showing;
    }

    private List<Showing> constructShowings(){
        List<Showing> showingList = new ArrayList<>();
        showingList.add(constructShowing());
        return showingList;
    }

    private ResponseObject<Showing> constructResponse(){
        ResponseObject<Showing> responseObject = new ResponseObject<>(true,"Test");
        responseObject.setSuccessful(true);
        responseObject.setContentList(constructShowings());
        responseObject.setBody("Film list retrieved successfully.");

        return responseObject;
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testAddShowing() {

        Showing showing = constructShowing();
        ResponseObject<Showing> responseObject = constructResponse();

        when(businessWare.addShowing(showing.getFilmId(), showing.getScreenType(), showing.getShowingTime(), showing.getDate())).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/addshowing/"+ showing.getFilmId()+"/"+showing.getScreenType()+"/"+
                showing.getShowingTime()+"/" +showing.getDate(), ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetShowingsByFilm(){
        Showing showing = constructShowing();
        ResponseObject<Object> responseObject = new ResponseObject<>(true,"Test");

        when(businessWare.findByFilmId(showing.getFilmId())).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getshowingsbyfilm/" + showing.getFilmId(), ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testBookTickets(){
        String[] seatsRequested = new String[] {"A1", "A2","B3","C4","D5","E1"};
        Showing showing = constructShowing();
        ResponseObject<Showing> responseObject = constructResponse();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");


        MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("0","4:4");
        bodyMap.add("1", "7:7");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(bodyMap, headers);

        when(businessWare.bookSeats("5d42e0249b6b570b7c9f1510",  seatsRequested)).thenReturn(responseObject);
        assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/booktickets/"+showing.getId(),requestEntity,ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

//    @RequestMapping(value = "/booktickets/{showingId}", method = RequestMethod.POST)
//    public ResponseObject<Showing> bookTickets(@PathVariable("showingId") String showingId, @RequestBody String[] seatsRequested){
//        return businessware.bookSeats(showingId, seatsRequested);
}
