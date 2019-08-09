package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.CommentFilter;
import com.lunacinemas.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import com.lunacinemas.businesslogic.ResponseObject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommentControllerTest {

    @Autowired
    @InjectMocks
    private CommentController controller;

    @Mock
    private CommentFilter businessWare;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testContextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testInsertComment() {
        Comment comment = new Comment();
        comment.setValues("5d4b1f119b6b5715a0055020", "Ian", "Can we make it shorter and quieter please");

        ResponseObject responseObject = new ResponseObject();

        when(businessWare.saveComment(comment)).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/insertcomment/" +comment.getId() + "/Ian/" + comment.getBody(), ResponseObject.class))
                .hasSameClassAs(responseObject);
    }

    @Test
    public void testGetComments() {

        ResponseObject responseObject = new ResponseObject();

        when(businessWare.getComments("5d4b1f119b6b5715a0055020")).thenReturn(responseObject);
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getcomments/5d4b1f119b6b5715a0055020", ResponseObject.class))
                .hasSameClassAs(responseObject);
    }
}
