package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.FilmGrabber;
import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.model.Film;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin()
public class FilmController extends MyController<FilmGrabber> {

    @RequestMapping(value = "/getallfilms", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject<Film> getFilms(){
        return businessware.getAllFilms();
    }

    @RequestMapping(value = "/searchfilms/{search}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject<Film> searchFilms(@PathVariable("search") String searchText){
        return businessware.searchFilms(searchText);
    }

    @RequestMapping(value = "/getfilm/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject<Optional<Film>> getFilms(@PathVariable("id") String id){
        return businessware.getById(id);
    }

    @RequestMapping(value = "/getupcomingfilms", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject<Film> getUpcomingFilms(){
        return businessware.getUpcomingFilms();
    }

    @RequestMapping(value = "/getnewfilms", method = RequestMethod.GET)
    @ResponseBody
    public ResponseObject<Film> getNewlyReleasedFilms(){
        return businessware.getReleasedFilms();
    }

}
