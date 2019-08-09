package com.lunacinemas.businesslogic;

import com.lunacinemas.model.Review;
import com.lunacinemas.persistence.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewFilter extends ContentFilter implements Requestable {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private ResponseObject<Review> responseObject;

    public ResponseObject<Review> saveReview(Review incomingReview){
        incomingReview.setReview(filter(incomingReview.getReview(), responseObject));
        repository.insert(incomingReview);
        responseObject.setSuccessful(true);
        responseObject.setBody("Review saved successfully");
        responseObject.setContentList(repository.findByFilmId(incomingReview.getFilmId()));
        return responseObject;
    }

    public ResponseObject<Review> getReviews(String filmId) {
        responseObject.setContentList(null);
        List<Review> reviews = repository.findByFilmId(filmId);
        if (reviews.size()>0){
            return responseObject.positive("Got all " + reviews.size() + " reviews associated with that film", reviews);
        } else {
            return responseObject.negative("No reviews found");
        }
    }

    public ResponseObject<Review> getReview(String reviewId){
        responseObject.setContentList(null);
        Optional<Review> review = repository.findById(reviewId);
        if (review.isPresent()){
            ArrayList<Review> reviewAsList = new ArrayList<>();
            reviewAsList.add(review.get());
            return responseObject.positive("Review found!",reviewAsList);
        } else {
            return responseObject.negative("No reviews found with that Id.");
        }
    }

}
