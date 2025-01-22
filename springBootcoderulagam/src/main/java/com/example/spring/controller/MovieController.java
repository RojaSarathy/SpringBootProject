package com.example.spring.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.spring.model.Movie;
import com.example.spring.movies.dataaccess.MovieListRepository;

@Controller
@RequestMapping("/")
public class MovieController {
//	
//	@RequestMapping("/")    
//	public String index()  
//	{    
//	return"index";    
//	}    
//   
   @Autowired
	private MovieListRepository movieListRepository;
	
	@RequestMapping(method=RequestMethod.GET,value="/movieList/{actor}")
	public String getMovieListController(@PathVariable("actor") String name, Model model ) {
//		List<Movie> movieList = new ArrayList<Movie>();
//		Movie movie = new Movie();
//		movie.setActor("tom");
//		movie.setDescription("mossion impasible");
//		movie.setName("mi3");
//		movieList.add(movie);
		//System.out.println(name);
		List<Movie> movieList=movieListRepository.findMoviesByActor(name);
		
		model.addAttribute("movies", movieList);
		
		return "movieList";
	}
	
	@RequestMapping(method =RequestMethod.POST,value="/movie",consumes ="application/json")
	public ResponseEntity<Object> addmovie(@RequestBody Movie movie){
		//System.out.println("movie values"+movie);
		movieListRepository.save(movie);
		return ResponseEntity.ok().build();
		
	}
	
}
