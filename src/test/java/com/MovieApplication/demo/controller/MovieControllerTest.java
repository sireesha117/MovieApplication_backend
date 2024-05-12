package com.MovieApplication.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.MovieApplication.demo.entity.Movie;
import com.MovieApplication.demo.service.impl.MovieServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class MovieControllerTest {
	@Mock
	private MovieServiceImpl movieService;

	@InjectMocks
	private MovieController movieS;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(movieS).build();
	}

	List<Movie> movieList = new ArrayList<Movie>();

	@Test
	public void getAllMoviesSuccess() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("2018");
		movie.setTheatreName("AMB");
		movie.setSeats(100);
		movie.setSeatsAvalible(100);
		movie.setShowTime("09:30AM");
		movie.setPrice(100);

		movieList.add(movie);
		when(movieService.getAllMovies()).thenReturn(movieList);

		List<Movie> mList = movieService.getAllMovies();
		assertEquals(movieList, mList);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/getAllMovies").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void getMovieByNameSuccess() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("2018");
		movie.setTheatreName("AMB");
		movie.setSeats(100);
		movie.setSeatsAvalible(100);
		movie.setShowTime("09:30AM");
		movie.setPrice(100);

		List<Movie> movieList = new ArrayList<Movie>();
		movieList.add(movie);

		when(movieService.getMovieByName("2018")).thenReturn(movieList);

		List<Movie> m = movieService.getMovieByName("2018");
		assertEquals(movieList, m);

		mockMvc.perform(
				MockMvcRequestBuilders.get("/api/v1/findmovieByName/2018").contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void addMovieSuccess() throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieName("2018");
		movie.setTheatreName("AMB");
		movie.setSeats(100);
		movie.setSeatsAvalible(100);
		movie.setShowTime("09:30AM");
		movie.setPrice(100);

		movieList.add(movie);
		when(movieService.addMovie(any())).thenReturn(movie);

		assertEquals(1, movieList.size());
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addMovie").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(movie)))
				.andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	public void addMovieFailure() throws Exception
	{
		
		when(movieService.addMovie(any())).thenReturn(null);
		
		Movie u1 = movieService.addMovie(null);
		assertNull(u1);
		
mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/addMovie").contentType(MediaType.APPLICATION_JSON)
.content(new ObjectMapper().writeValueAsString(u1))).andExpect(MockMvcResultMatchers.status().is4xxClientError());
		
	}

	@Test
    public void deleteMovieByIds() throws Exception {   
		when(movieService.deleteMovie(1)).thenReturn(true);
		boolean u1=movieService.deleteMovie(1);
		assertTrue(u1);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/deleteMovie/101").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(u1))).andExpect(MockMvcResultMatchers.status().isNotFound());
		
    }
}