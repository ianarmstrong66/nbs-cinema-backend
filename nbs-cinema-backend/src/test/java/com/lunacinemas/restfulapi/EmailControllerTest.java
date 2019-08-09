package com.lunacinemas.restfulapi;

import com.lunacinemas.model.LunaEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmailControllerTest {

    @Autowired
    @InjectMocks
    private EmailController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
   
    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testSendEmailReturn() {
    	LunaEmail lunaEmail = new LunaEmail("Big Daddy", "bigdaddy@gmail.com", "Wrestling Movie", "Why are there no more descent Wrestling movies being shown at your cinema?\nRegards\nBig Daddy");
        assertThat(this.restTemplate.postForObject(
        		"http://localhost:" + port + "/sendEmail",
        		lunaEmail,
        		String.class)
        )
        .contains("{\"response\":\"Message sent successfully.\"}");
    }    
}
