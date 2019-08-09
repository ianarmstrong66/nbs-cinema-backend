package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.businesslogic.ReviewFilter;
import com.lunacinemas.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class ReviewController extends MyController<ReviewFilter> {

    @Autowired
    private Review incomingReview;

    @RequestMapping(value = "/insertreview/{filmId}/{rating}/{review}/{username}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject insertReview(@PathVariable String filmId, @PathVariable String rating, @PathVariable String review, @PathVariable String username) {
        incomingReview.setValues(filmId, rating, review, username);
        return businessware.saveReview(incomingReview);
    }

    @RequestMapping(value = "/getreviews/{filmId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getReviews(@PathVariable("filmId") String filmId) {
        return businessware.getReviews(filmId);
    }

    @RequestMapping(value = "/getreview/{reviewId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getReview(@PathVariable("reviewId") String reviewId) {
        return businessware.getReview(reviewId);
    }
}
