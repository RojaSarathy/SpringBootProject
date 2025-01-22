package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Movie;

@RestController
@RequestMapping("/api/movie")
public class MoviesController {

	private static List<Movie> movies = new ArrayList<Movie>();
	
	@GetMapping
	public List<Movie> getAllMovieList(){
		return movies;
	}
	
	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		movies.add(movie);
		return movie;
	}
	
}
