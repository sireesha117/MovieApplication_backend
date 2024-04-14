package com.MovieApplication.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Movie {

	@Id

	private int movieId;
	private String movieName;
	private String theatreName;
	private int seats;
	private int seatsAvalible;
	private String showTime;
	private double price;
	
	public Movie() {}
	public Movie(int movieId,String movieName, String theatreName, int seats, int seatsAvalible, String showTime,
			double price) {
		super();
		this.movieId=movieId;
		
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.seats = seats;
		this.seatsAvalible = seatsAvalible;
		this.showTime = showTime;
		this.price = price;
	}

	
	


	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getSeatsAvalible() {
		return seatsAvalible;
	}

	public void setSeatsAvalible(int seatsAvalible) {
		this.seatsAvalible = seatsAvalible;
	}

}
