package com.lunacinemas.restfulapi;

import com.lunacinemas.businesslogic.ResponseObject;
import com.lunacinemas.businesslogic.ShowingHandler;
import com.lunacinemas.model.Showing;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
@CrossOrigin()
public class ShowingController extends MyController<ShowingHandler> {

	@RequestMapping(value = "/addshowing/{filmId}/{screenType}/{time}/{date}", method = RequestMethod.GET)
	public ResponseObject<Showing> addShowing(@PathVariable("filmId") String filmId,
		 	@PathVariable("screenType") String screenType, @PathVariable("time") String time, @PathVariable("date") String date){
		return businessware.addShowing(filmId, screenType, time, date);
	}

	@RequestMapping(value = "/getshowingsbyfilm/{filmId}", method = RequestMethod.GET)
	public ResponseObject<Object> getShowingsByFilm(@PathVariable("filmId") String filmId){
		return businessware.findByFilmId(filmId);
	}

	@RequestMapping(value = "/booktickets/{showingId}", method = RequestMethod.POST)
	public ResponseObject<Showing> bookTickets(@PathVariable("showingId") String showingId, @RequestBody String[] seatsRequested){
		return businessware.bookSeats(showingId, seatsRequested);
	}

}
