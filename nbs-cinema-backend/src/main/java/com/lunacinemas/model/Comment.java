package com.lunacinemas.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Service
public class Comment {

    @Id
    private String _id;
    private String reviewId;
    private String username;
    private String body;

    public void setValues(String reviewId, String username, String body){
        this.reviewId = reviewId;
        this.username = username;
        this.body = body;
    }

    public String getId() {
        return _id;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
