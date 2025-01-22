package com.example.spring.movies.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Movie;

public interface MovieListRepository extends JpaRepository<Movie, Long>{

	List<Movie>findMoviesByActor(String name);
	//List<Movie> findMoviesByActor(String name);
	
	//Movie findByName(String name);
	
	
}
