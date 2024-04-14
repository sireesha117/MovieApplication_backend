package com.MovieApplication.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MovieApplication.demo.entity.Movie;
import com.MovieApplication.demo.exception.DuplicateMovieIdExceptions;
@Service
public interface MovieService {
	public List<Movie> getAllMovies();
	public Movie addMovie(Movie book)throws DuplicateMovieIdExceptions;
	public boolean deleteMovie(int mid);
	public Movie getMovieById(int mid);
	public List<Movie> getMovieByName(String mname);
	public boolean updateMovie(Movie movie);

}
