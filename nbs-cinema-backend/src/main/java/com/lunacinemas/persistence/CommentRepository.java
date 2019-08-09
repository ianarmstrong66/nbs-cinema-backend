package com.lunacinemas.persistence;

import com.lunacinemas.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByReviewId(String ReviewId);

    void deleteAll();

}
