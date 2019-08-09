package com.lunacinemas.businesslogic;

import com.lunacinemas.model.Film;
import com.lunacinemas.model.Showing;
import com.lunacinemas.persistence.FilmRepository;
import com.lunacinemas.persistence.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowingHandler implements Requestable {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ShowingRepository showingRepository;
    @Autowired
    private ResponseObject<Object> responseWithFilm;
    @Autowired
    private ResponseObject<Showing> response;
    @Autowired
    private Showing incomingShowing;

    public ResponseObject<Object> findByFilmId(String filmId) {
        List<Showing> showings = showingRepository.findByFilmId(filmId);
        Film film = filmRepository.findById(filmId).get();
        ArrayList<Object> listToReturn = new ArrayList<>();
        listToReturn.add(film);
        listToReturn.add(1,showings);
        if (showings.size()>0){
            return responseWithFilm.positive("Showing retrieved successfully", listToReturn);
        } else {
            return responseWithFilm.setAll(false,"No showings found for that film", listToReturn);
        }
    }

    public synchronized ResponseObject<Showing> bookSeats(String showingId, String[] requestedSeats){
        Optional<Showing> showingFromDB = showingRepository.findById(showingId);
        if (showingFromDB.isPresent()){
            Showing showing = showingFromDB.get();
            try {
                showing.getSeatAvailability();
                showing.setSeatAvailability(grabSpecificSeats(showing.getSeatAvailability(),requestedSeats));
                showing.setSeatsAvailable(showing.getSeatsAvailable()-requestedSeats.length);
                showingRepository.save(showing);
                ArrayList<Showing> showingAsList = new ArrayList<>();
                showingAsList.add(showing);
                return response.positive("Tickets booked successfully. Price:"+(showing.getPricePerSeat()*requestedSeats.length), showingAsList);
            } catch (Exception e) {
                ArrayList<Showing> showingAsList = new ArrayList<>();
                showingAsList.add(showing);
                return response.setAll(false,"Some of your seats are already taken.", showingAsList);
            }
        } else {
            return response.negative("Unable to find that showing in the database");
        }
    }

    public ResponseObject<Showing> addShowing(String filmId, String screenType, String time, String date){
        if (checkFimId(filmId)){
            return response.negative("No such filmId in database");
        }
        boolean isDbox = "Dbox".equals(screenType);
        incomingShowing.resetId();
        incomingShowing.setFilmId(filmId);
        incomingShowing.setShowingTime(time);
        incomingShowing.setDate(date);
        incomingShowing.setScreenType(screenType);
        incomingShowing.setSeatAvailability(isDbox ? makeDboxScreen() : makeStandardScreen());
        incomingShowing.setTotalNumberOfSeats(isDbox ? 20 : 72 );
        incomingShowing.setSeatsAvailable(incomingShowing.getTotalNumberOfSeats());
        incomingShowing.setPricePerSeat(isDbox ? 15 : 8 );
        showingRepository.insert(incomingShowing);
        return response.positive("Showing added successfully", showingRepository.findByFilmId(filmId));
    }

    private boolean[][] makeStandardScreen() {
        int[] rowSizes = {5,5,7,7,7,7,7,7,10,10};
        boolean[][] seatLayout = new boolean[10][];
        for (int i = 0 ; i < seatLayout.length ; i++){
            seatLayout[i] = new boolean[rowSizes[i]];
        }
        return seatLayout;
    }

    private boolean[][] makeDboxScreen() {
        return new boolean[4][5];
    }

    private boolean checkFimId(String filmId){
        return !filmRepository.findById(filmId).isPresent();
    }

    private boolean[][] grabSpecificSeats(boolean[][] currentSeatAvailability, String[] seatPositions) throws Exception {
        for (String seatPos : seatPositions){
            if (checkSeat(seatPos, currentSeatAvailability)){
                bookSeat(seatPos,currentSeatAvailability);
            } else {
                throw new IOException("Seat taken");
            }
        }
        return currentSeatAvailability;
    }

    private boolean checkSeat(String seatPos, boolean[][] currentSeats){
        String[] positions = seatPos.split(":");
        int posRow = Integer.parseInt(positions[0]);
        int posSeatNum = Integer.parseInt(positions[1]);
        return !currentSeats[posRow][posSeatNum];
    }

    private boolean[][] bookSeat(String seatPos, boolean[][] currentSeats){
        String[] positions = seatPos.split(":");
        int posRow = Integer.parseInt(positions[0]);
        int posSeatNum = Integer.parseInt(positions[1]);
        currentSeats[posRow][posSeatNum]=true;
        return currentSeats;
    }

}
