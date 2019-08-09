package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.CommentFilter;
import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin()
public class CommentController extends MyController<CommentFilter> {

    @Autowired
    private Comment incomingComment;

    @RequestMapping(value = "/insertcomment/{reviewId}/{username}/{body}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject insertComment(@PathVariable String reviewId, @PathVariable String username, @PathVariable String body) {
        incomingComment.setValues(reviewId, username, body);
        return businessware.saveComment(incomingComment);
    }

    @RequestMapping(value = "/getcomments/{reviewId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject getComments(@PathVariable String reviewId) {
        return businessware.getComments(reviewId);
    }

}