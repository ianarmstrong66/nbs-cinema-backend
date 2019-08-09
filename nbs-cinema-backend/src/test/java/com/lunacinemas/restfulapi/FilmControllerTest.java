package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.FilmGrabber;
import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.model.Film;
import com.lunacinemas.persistence.FilmRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpUriRequest;
//import org.springframework.http.HttpStatus;
//import wiremock.org.apache.http.HttpResponse;
//import wiremock.org.apache.http.client.ClientProtocolException;
//import wiremock.org.apache.http.client.methods.HttpGet;
//import wiremock.org.apache.http.client.methods.HttpUriRequest;
//import wiremock.org.apache.http.impl.client.HttpClientBuilder;
//
//import java.io.IOException;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
//
//import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
//import static org.hamcrest.core.StringContains.containsString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FilmControllerTest {

    @Autowired
    @InjectMocks
    private FilmController controller;

    @Mock
    private FilmRepository repository;

    @Mock
    private FilmGrabber businessWare;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private Film constructFilm(){
        Film film = new Film();
        String[] actors = new String[1];
        String[] directors = new String[1];
        String[] genres = new String[1];
        actors[0] = "Gerard Butler, Morgan Freeman, Jada Pinkett Smith, Lance Reddick, Tim ...";
        directors[0] = "Ric Roman Waugh";
        genres[0] = "Action";
        film.setActors(actors);
        film.setBriefDescription("Secret Service Agent Mike Banning is framed for the attempted assassination of the President and must evade his own agency and the FBI as he tries to uncover the real threat.");
        film.setClassification("Class15");
        film.setDetailedDescription("When there is an assassination attempt on US President Allan Trumbull (Morgan Freeman), his trusted confidant, Secret Service Agent Mike Banning (Gerard Butler), is wrongfully accused and taken into custody. After escaping from capture, he becomes a man on the run and must evade his own agency and outsmart the FBI in order to find the real threat to the President. Desperate to uncover the truth, Banning turns to unlikely allies to help clear his name, keep his family from harm and save the country from imminent danger.");
        film.setDirectors(directors);
        film.setImagePath("/UpcomingFilmsImages/angel.jpg");
        film.setLength("2h 01m");
        film.setReleased(false);
        film.setTitle("Angel Has Fallen");
        film.setYear("2019");

        return film;
    }

    private List<Film> constructFilms(){
        List<Film> filmList = new ArrayList<>();
        filmList.add(constructFilm());
        return filmList;
    }

    private ResponseObject<Film> constructResponse(){
        ResponseObject<Film> responseObject = new ResponseObject<>();
        responseObject.setSuccessful(true);
        responseObject.setContentList(constructFilms());
        responseObject.setBody("Film list retrieved successfully.");

        return responseObject;
    }

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllFilms(){
        ResponseObject<Film> responseObject = constructResponse();
        when(repository.findAll()).thenReturn(constructFilms());
        assertThat(this.restTemplate.getForObject("http://localhost:" +port + "/getallfilms", ResponseObject.class))
                .hasSameClassAs(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" +port + "/getallfilms", ResponseObject.class))
                .isEqualToComparingOnlyGivenFields(responseObject, new String[]{"body","successful"});
    }

    @Test
    public void testSearchFilms(){
        ResponseObject<Film> responseObject = constructResponse();
        String searchText = "Action";

        when(businessWare.searchFilms(searchText)).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" +port + "/searchfilms/"+searchText, ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetFilm() {
        ResponseObject<Optional<Film>> responseObject = new ResponseObject<>();
        String id = "1234";
        when(businessWare.getById(id)).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getfilm/" + id, ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetUpcomingFilms() {
        ResponseObject<Film> responseObject = new ResponseObject<>();
        when(businessWare.getUpcomingFilms()).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getupcomingfilms", ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetNewlyReleasedFilms() {
        ResponseObject<Film> responseObject = constructResponse();
        when(businessWare.getReleasedFilms()).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getnewfilms", ResponseObject.class))
                .hasSameClassAs(responseObject);
    }
}
