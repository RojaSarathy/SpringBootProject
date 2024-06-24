package com.example.todo.TodoRestServices.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.todo.TodoRestServices.entity.Todo;
import com.example.todo.TodoRestServices.service.TodohardCodeService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	TodohardCodeService todoService;

	@GetMapping("/users/{userName}/todos")
	public List<Todo> getAllTodos(@PathVariable String userName){
		
		return todoService.findAll();
		
	}
	
	@DeleteMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Void> deleteTodoId(@PathVariable String userName,@PathVariable Long id){
	Todo todo=	todoService.deleteById(id);
	
	if(todo!=null) {
		return ResponseEntity.noContent().build();
	}
	return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/{userName}/todos/{id}")
	public Todo getByIdTodo(@PathVariable String userName,@PathVariable Long id) {
		return todoService.findById(id);
	}
	
	@PutMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName,
			@PathVariable Long id,@RequestBody Todo todo){
		
		Todo todoUpdated = todoService.save(todo);
		return new  ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	@PostMapping("/users/{userName}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String userName,@RequestBody Todo todo){
		
		Todo createTodo = todoService.save(todo);
		 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		 .path("/{id}").buildAndExpand(createTodo.getId()).toUri();
		// uri Assing local variable ctrl+1
		
		 return ResponseEntity.created(uri).build();
	}
	
}
