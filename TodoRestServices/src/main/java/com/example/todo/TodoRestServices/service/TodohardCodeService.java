package com.example.todo.TodoRestServices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo.TodoRestServices.entity.Todo;

@Service
public class TodohardCodeService {
	
	private static List<Todo> todos = new ArrayList<>();
	private static long idcounter= 0;
	//private static Long idcounters = Long.valueOf(idcounter);
	
	static {
		todos.add(new Todo( ++idcounter,"roja","Learn to danse",new Date(),false));
		todos.add(new Todo( ++idcounter,"roja","Learn to english",new Date(),true));
		todos.add(new Todo( ++idcounter,"roja","Learn to veena",new Date(),true));
	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		
		if(todo == null) return null;
		
		if(todos.remove(todo)) {
		return todo;
		}
		
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo : todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0 ) {
			todo.setId(++idcounter);
			todos.add(todo);
		}else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	

}
