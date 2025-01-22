package com.example.spring.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.swagger.model.MovieModel;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	private List<MovieModel> movies=new ArrayList<MovieModel>(); 
	
	
	@GetMapping
	public List<MovieModel> getAllMovies(){
		return movies;
	}
	
	
	@PostMapping
	public MovieModel setMovie(@RequestBody MovieModel movieModel) {
		movies.add(movieModel);
		
		return movieModel;
	}
	

}
