package com.MovieApplication.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MovieApplication.demo.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
	@Query(value = "select m from Movie m where m.movieName= :mname")
	public List<Movie> findByName(String mname);

}
