package com.lunacinemas.businesslogic;

import com.lunacinemas.model.Comment;
import com.lunacinemas.persistence.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentFilter extends ContentFilter implements Requestable {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private ResponseObject<Comment> responseObject;

    public ResponseObject saveComment(Comment incomingComment) {
        incomingComment.setBody(filter(incomingComment.getBody(), responseObject));
        repository.save(incomingComment);
        responseObject.setSuccessful(true);
        responseObject.setContentList(null);
        responseObject.setBody("Comment saved successfully. ");
        return responseObject;
    }

    public ResponseObject getComments(String reviewId) {
        List<Comment> comments = repository.findByReviewId(reviewId);
        responseObject.positive("Got all " + comments.size() + " comments associated with that review", comments);
        return responseObject;
    }
}