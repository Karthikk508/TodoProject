package com.karthik.springBoot.myFirstWebApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

// <Type,type of primary key>

public interface TodoRepository extends JpaRepository<Todo,Integer> {
	
	public List<Todo> findByUsername(String username);

}
