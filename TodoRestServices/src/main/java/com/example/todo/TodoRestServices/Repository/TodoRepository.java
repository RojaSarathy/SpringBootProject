package com.example.todo.TodoRestServices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.TodoRestServices.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	
	List<Todo>findByUsername(String name);
}
