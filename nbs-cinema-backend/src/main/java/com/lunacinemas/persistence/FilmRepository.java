
package com.lunacinemas.persistence;

import com.lunacinemas.model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository  extends MongoRepository<Film, String> {

    Optional<Film> findById(String id);

    List<Film> findByReleased(boolean released);

    Film findByTitle(String name);

}
