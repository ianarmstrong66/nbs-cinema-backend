package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.ResponseObject;
import org.junit.Test;
import com.lunacinemas.businesslogic.Initialise;
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
public class InitialiseControllerTest {

    @Autowired
    @InjectMocks
    private InitialiseController  controller;

    @Mock
    private Initialise businessWare;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testInitialise(){
        ResponseObject<Object> responseObject = new ResponseObject<>();
        when(businessWare.initialiseData()).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/initialise", ResponseObject.class))
                .hasSameClassAs(responseObject);
    }
}
