package com.karthik.springBoot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static List<Todo> list = new ArrayList<>();
	
	private static int count = 0;
	
	static {
		
		list.add(new Todo(++count, "karthik", "Learn Java", LocalDate.now().plusYears(1), false));
		list.add(new Todo(++count, "karthik", "Learn sql", LocalDate.now().plusYears(1), false));
		list.add(new Todo(++count, "karthik", "Learn SpringBoot", LocalDate.now().plusYears(1), false));
		list.add(new Todo(++count, "karthik", "Learn DSA", LocalDate.now().plusYears(1), false));
	}
	
	
	public List<Todo> listOfTodos(String username){
		
		return list;
		
	}
	public void addTodo(String username,String description,LocalDate targetDate,boolean done) {
		
		Todo todo = new Todo(++count,username,description,targetDate,done);
		list.add(todo);
	}
	
	public void deleteTodo(int id,String string) {
		
		//Functional programming 
		
		 Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		 list.removeIf(predicate);
		 
		 
//		for(int i = 0; i<list.size(); i++) {
//			
//			if(list.get(i).getId() == id) {
//				list.remove(i);
//			}
//		}
	}
	public void updateTodo(int id,String update) {
	
		for(int i = 0; i<list.size(); i++) {
			
			if(list.get(i).getId() == id) {
				
				list.get(i).setDescription(update);
			}
		}
	
	}
	public Todo findById(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return list.stream().filter(predicate).findFirst().get();
	}

}
