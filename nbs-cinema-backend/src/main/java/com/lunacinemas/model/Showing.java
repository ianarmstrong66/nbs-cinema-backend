package com.lunacinemas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Showing {

	@Id
	private String _id;
	private String filmId;
	private String showingTime;
	private String date;
	private Integer seatsAvailable;
	private Integer totalNumberOfSeats;
	private boolean[][] seatAvailability; //Defaults to false, so false means not yet booked and therefore available
	private String screenType;
	private int pricePerSeat;

	public Showing(){}

	public Showing(String filmId, String showingTime, String date, Integer seatsAvailable, Integer totalNumberOfSeats, boolean[][] seatAvailability, String screenType, int pricePerSeat) {
		this.filmId = filmId;
		this.showingTime = showingTime;
		this.date = date;
		this.seatsAvailable = seatsAvailable;
		this.totalNumberOfSeats = totalNumberOfSeats;
		this.seatAvailability = seatAvailability;
		this.screenType = screenType;
		this.pricePerSeat = pricePerSeat;
	}

	public String getId() {
		return _id;
	}

	public void resetId() {
		this._id = null;
	}

	public String getFilmId() {
		return filmId;
	}

	public void setFilmId(String filmId) {
		this.filmId = filmId;
	}

	public String getShowingTime() {
		return showingTime;
	}

	public void setShowingTime(String showingTime) {
		this.showingTime = showingTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public Integer getTotalNumberOfSeats() {
		return totalNumberOfSeats;
	}

	public void setTotalNumberOfSeats(Integer totalNumberOfSeats) {
		this.totalNumberOfSeats = totalNumberOfSeats;
	}

	public boolean[][] getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(boolean[][] seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getScreenType() {
		return screenType;
	}

	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}

	public int getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(int pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	public void setId(String id) {
		this._id = id;
	}
}