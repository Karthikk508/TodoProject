package com.karthik.springBoot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	private TodoService serviceObj;

	public TodoController(TodoService service) {
		this.serviceObj = service;
	}

	@RequestMapping("list-todos")
	public String todos(ModelMap model) {

		String username = (String) model.get("name");
		List<Todo> list = serviceObj.listOfTodos(username);
		model.put("todos", list);

		return "listTodos";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {

		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "45654", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "todo";
	}
	//
	// In post request the todo description is bounded with the tag present in the
	// jsp (description)

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String returToListTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		// List<Todo> list = serviceObj.listOfTodos("karthik");
		// model.put("todos", list);

		if (result.hasErrors()) {

			return "todo";
		}

		String username = (String) model.get("name");

		serviceObj.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);

		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id, ModelMap model) {

		serviceObj.deleteTodo(id, (String) model.get("name"));
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodo(@RequestParam int id, ModelMap model) {

		// String username = (String) model.get("name");

		Todo todo = serviceObj.findById(id);
		model.put("todo", todo);

		return "UpdateTodo";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String UpdateTodoPage(@RequestParam int id, @Valid Todo todo, BindingResult result) {
		
		

		return "redirect:list-todos";
	}

}
