package com.lunacinemas.persistence;

import com.lunacinemas.model.Showing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowingRepository extends MongoRepository<Showing, String>{

    List<Showing> findByFilmId(String filmId);

    Optional<Showing> findById(String id);

    Showing insert(Showing showing);

    void deleteById(String id);

}