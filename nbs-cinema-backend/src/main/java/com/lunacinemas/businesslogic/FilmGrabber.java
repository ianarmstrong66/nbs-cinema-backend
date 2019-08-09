package com.lunacinemas.businesslogic;

import com.lunacinemas.model.Film;
import com.lunacinemas.persistence.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class FilmGrabber extends StringManipulator implements Requestable {

    @Autowired
    private FilmRepository repository;
    @Autowired
    private ResponseObject<Optional<Film>> searchRes;
    @Autowired
    private ResponseObject<Film> res;
    @Autowired
    private ArrayList<Film> searchResults;
    private String regexToSplitIntoWords = "\\W";

    public ResponseObject<Optional<Film>> getById(String id){
        List<Optional<Film>> filmAsList = new ArrayList<>();
        filmAsList.add(repository.findById(id));
        searchRes.setSuccessful(true);
        searchRes.setBody("Film retrieved successfully.");
        searchRes.setContentList(filmAsList);
        return searchRes;
    }

    public ResponseObject<Film> getAllFilms(){
        List<Film> fullFilmList = repository.findAll();
        res.setSuccessful(true);
        res.setBody("Film list retrieved successfully.");
        res.setContentList(fullFilmList);
        return res;
    }

    public ResponseObject<Film> getReleasedFilms() {
        List<Film> releasedFilmList = repository.findByReleased(true);
        res.setSuccessful(true);
        res.setBody("Released film list retrieved successfully.");
        res.setContentList(releasedFilmList);
        return res;
    }

    public ResponseObject<Film> getUpcomingFilms() {
        List<Film> releasedFilmList = repository.findByReleased(false);
        res.setSuccessful(true);
        res.setBody("Upcoming film list retrieved successfully.");
        res.setContentList(releasedFilmList);
        return res;
    }

    public ResponseObject<Film> searchFilms(String searchText) {
        searchResults.clear();
        String searchRegex = getSearchRegex(searchText);
        List<Film> fullFilmList = repository.findAll();
        for (Film film : fullFilmList){
            if (singleFilmSearch(film, searchRegex)){
                searchResults.add(film);
            }
        }
        res.setContentList(searchResults);
        return res;
    }

    private String getSearchRegex(String rawSearchText){
        String[] wordArray = rawSearchText.split(regexToSplitIntoWords);
        StringBuilder resultingRegex = new StringBuilder(".*(");
        resultingRegex.append(getRegex(wordArray[0]));
        for (int i = 1 ; i < wordArray.length ; i++) {
            resultingRegex.append("|");
            resultingRegex.append(getRegex(wordArray[i]));
        }
        resultingRegex.append(").*");
        return resultingRegex.toString();
    }

    private boolean getMatch(String regex, String searchString){
        return Pattern.compile(regex).matcher(searchString).matches();
    }

    private boolean singleFilmSearch(Film film, String searchRegex){
        if (getMatch(searchRegex, film.getTitle())){
            return true;
        }
        for (String director : film.getDirectors()){
            if (getMatch(searchRegex, director)){
                return true;
            }
        }
        for (String genre : film.getGenres()){
            if (getMatch(searchRegex, genre)){
                return true;
            }
        }
        for (String actor : film.getActors()){
            if (getMatch(searchRegex, actor)){
                return true;
            }
        }
        return false;
    }

}
