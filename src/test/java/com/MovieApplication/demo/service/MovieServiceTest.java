package com.MovieApplication.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.MovieApplication.demo.entity.Movie;
import com.MovieApplication.demo.exception.DuplicateMovieIdExceptions;
import com.MovieApplication.demo.repository.MovieRepository;
import com.MovieApplication.demo.service.impl.MovieServiceImpl;

public class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;

	@InjectMocks
	private MovieServiceImpl movieService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllMoviesSuccess() {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("2018");
		movie.setTheatreName("AMB");
		movie.setSeats(100);
		movie.setSeatsAvalible(100);
		movie.setShowTime("09:30AM");
		movie.setPrice(100);

		List<Movie> movieList = new ArrayList<>();
		movieList.add(movie);

		when(movieRepository.findAll()).thenReturn(movieList);

		List<Movie> returnedMovieList = movieService.getAllMovies();
		assertEquals(movieList, returnedMovieList);
	}

	@Test
	public void getMovieByNameSuccess() {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("2018");
		movie.setTheatreName("AMB");
		movie.setSeats(100);
		movie.setSeatsAvalible(100);
		movie.setShowTime("09:30AM");
		movie.setPrice(100);

		List<Movie> movieList = new ArrayList<>();
		movieList.add(movie);

		when(movieRepository.findByName("2018")).thenReturn(movieList);

		List<Movie> returnedMovieList = movieService.getMovieByName("2018");
		assertEquals(movieList, returnedMovieList);
	}

	@Test
	public void addMovieSuccess() throws DuplicateMovieIdExceptions {
		Movie movie = new Movie();
		movie.setMovieId(2023);
		movie.setMovieName("2018");
		movie.setTheatreName("AMB");
		movie.setSeats(100);
		movie.setSeatsAvalible(100);
		movie.setShowTime("09:30AM");
		movie.setPrice(100);

		when(movieRepository.save(movie)).thenReturn(movie);

		Movie savedMovie = movieService.addMovie(movie);
		assertEquals(movie, savedMovie);
	}

	@Test
    public void deleteMovieSuccess() {
        when(movieRepository.existsById(1)).thenReturn(true);
        

        boolean isDeleted = movieService.deleteMovie(1);
        assertTrue(isDeleted);
    }

	@Test
	void testUpdateMovie() {
		Movie existingMovie = new Movie();
		existingMovie.setMovieId(42);
		Movie updatedMovie = new Movie();
		updatedMovie.setMovieId(42);
		updatedMovie.setSeatsAvalible(100);

		when(movieRepository.findById(existingMovie.getMovieId())).thenReturn(Optional.of(existingMovie));
		when(movieRepository.save(existingMovie)).thenReturn(updatedMovie);

		assertTrue(movieService.updateMovie(updatedMovie));
		assertEquals(100, existingMovie.getSeatsAvalible());
	}
}