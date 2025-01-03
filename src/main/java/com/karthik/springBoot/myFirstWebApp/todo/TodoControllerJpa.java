package com.karthik.springBoot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {
	
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	

	@RequestMapping("list-todos")
	public String todos(ModelMap model) {

		String username = getLoggedInUsername();
		List<Todo> list = todoRepository.findByUsername(username);
		model.put("todos", list);

		return "ListTodos";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {

		String username = getLoggedInUsername();
		Todo todo = new Todo(0, username, "Enter your description", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);

		return "Addtodo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String returToListTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
	
		if (result.hasErrors()) {
			return "Addtodo";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);

		return "redirect:list-todos";
	}

	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id, ModelMap model) {

		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String ShowUpdateTodo(@RequestParam int id, ModelMap model) {

		Todo todo = todoRepository.findById(id).get();
		model.put("todo", todo);
		return "UpdateTodo";

	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String UpdateTodoPage(@RequestParam int id,ModelMap model, @Valid Todo todo, BindingResult result) {
		
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoRepository.save(todo);
		
		return "redirect:list-todos";
	}
	
    public String getLoggedInUsername() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
