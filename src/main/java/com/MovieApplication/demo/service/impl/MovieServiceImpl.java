package com.MovieApplication.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MovieApplication.demo.entity.Movie;
import com.MovieApplication.demo.exception.DuplicateMovieIdExceptions;
import com.MovieApplication.demo.repository.MovieRepository;
import com.MovieApplication.demo.service.MovieService;

import jakarta.transaction.Transactional;


@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepo;

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movielist = movieRepo.findAll();
		if (movielist != null && movielist.size() > 0) {
			return movielist;
		}
		return null;
	}

	@Override
	public Movie addMovie(Movie movie) throws DuplicateMovieIdExceptions  {
		Optional<Movie> opObj = movieRepo.findById(movie.getMovieId());

		if (opObj.isPresent()) {
			throw new DuplicateMovieIdExceptions();
		}
		return movieRepo.save(movie);
	}

	@Override
	public boolean deleteMovie(int mid) {
		movieRepo.deleteById(mid);
		return true;
	}

	@Override
	public Movie getMovieById(int mid) {
		Optional<Movie> movie = movieRepo.findById(mid);
		if (movie.isPresent()) {
			return movie.get();
		}

		return null;
	}
	@Override
	public List<Movie> getMovieByName(String mname) {
		List<Movie> movie = movieRepo.findByName(mname);
		if (movie!=null) {
			return movie;
		}

		return null;
	}

	@Override
	@Transactional
	public boolean updateMovie(Movie movie){
//		Movie movie1 = movieRepo.findById(movie.getMovieId());
		Optional<Movie> foundMovie = movieRepo.findById(movie.getMovieId());
		Movie movie1 = foundMovie.get();
		
		if(foundMovie.isEmpty()) {
			return false;
		}
		
		movie1.setSeatsAvalible(movie.getSeatsAvalible());
		movie1.setMovieName(movie.getMovieName());
		movie1.setTheatreName(movie.getTheatreName());
		movie1.setShowTime(movie.getShowTime());
		movie1.setPrice(movie.getPrice());
		movieRepo.save(movie1);
		return true;
		
		
	}

}
