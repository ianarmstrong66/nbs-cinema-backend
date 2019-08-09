package com.lunacinemas.model;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

@Service
public class Review {

    @Id
    private String _id;
    private String username;
    private String rating;
    private String review;
    private String filmId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return _id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public Review() {}

    public Review(String filmId, String rating, String review) {
        this.rating = rating;
        this.review = review;
        this.filmId = filmId;
    }

    @Override
    public String toString() {
        return String.format(
                "Description[id=%s, rating='%s', review='%s', filmId='%s']",
                _id, rating, review, filmId);
    }

    public void setValues(String film, String rating, String review, String username) {
        this._id=null;
        this.rating = rating;
        this.review = review;
        this.filmId = film;
        this.username = username;
    }
}
