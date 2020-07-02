package dev.subhashmeena.todo;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@CrossOrigin(origins="*")
@RestController
public class TodoController {

	@Autowired
	TodoRepository repository;
	
	@RequestMapping(value="/todos", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Todo> getAllTodos(){
		return repository.findAll();
		
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createTodo(@RequestBody Todo todo) {
		repository.save(todo);
		return "200 OK";
	}
	
	@RequestMapping(value="/todo/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Todo getTodo(@PathVariable("id") Long id) {
		return repository.findById(id).orElse(null);
	}
	
	@RequestMapping(value="/todo", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateTodo(@RequestBody Todo todo) {
		 repository.saveAndFlush(todo);
		 return "Successful";
	}
	
	@RequestMapping(value="/load", method=RequestMethod.GET)
	public String load() {
		try {
		    Thread.sleep(5 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		
		return "Service Response";
	}
	
	@RequestMapping(value="/todo/{id}", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String deleteTodo(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "200 OK";
	}
}
