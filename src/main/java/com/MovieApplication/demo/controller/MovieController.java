package com.MovieApplication.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MovieApplication.demo.entity.Movie;
import com.MovieApplication.demo.exception.DuplicateMovieIdExceptions;
import com.MovieApplication.demo.service.MovieService;
import com.MovieApplication.demo.service.TicketService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class MovieController {
	@Autowired
	private MovieService ms;
	@Autowired
	private TicketService ts;

	@PostMapping("/addMovie")
	public ResponseEntity<?> addMovie(@RequestBody Movie movie) throws DuplicateMovieIdExceptions {
		
		if (ms.addMovie(movie) != null) {

			return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
		}

		return new ResponseEntity<String>("movie is null", HttpStatus.NO_CONTENT);
	}

	@PutMapping("/updatemovie") // done
	public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
		
		if (ms.updateMovie(movie)) {
			return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("movie does not exists", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getAllMovies") // done
	public ResponseEntity<?> getMovies() {
		List<Movie> movielist = ms.getAllMovies();
		if (movielist != null) {
			return new ResponseEntity<List<Movie>>(movielist, HttpStatus.OK);
		}
		return new ResponseEntity<String>("No shows Avalible", HttpStatus.NO_CONTENT);

	}

	@Transactional
	@DeleteMapping("/delete/{mid}")
	public ResponseEntity<?> deleteMovieById(@PathVariable("mid") int mid) {
	    boolean ticketsDeleted = ts.deleteTicket(mid);
	    boolean movieDeleted = ms.deleteMovie(mid);

	    if (movieDeleted) {
	        return new ResponseEntity<>("Movie Deleted", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Movie Not Found", HttpStatus.NOT_FOUND);
	    }
	}

	@GetMapping("/findmovie/{mid}")
	public ResponseEntity<?> findMovie(@PathVariable("mid") int mid) {
		return new ResponseEntity<Movie>(ms.getMovieById(mid), HttpStatus.OK);
	}

	@GetMapping("/findmovieByName/{mname}")
	public ResponseEntity<?> findMovieByName(@PathVariable("mname") String mname) {
		return new ResponseEntity<List<Movie>>(ms.getMovieByName(mname), HttpStatus.OK);

	}

}
