package com.spring.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.course.entities.User;
import com.spring.course.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource
{
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll()
	{	
		return ResponseEntity.ok(userService.findAll());
	}
	
	@GetMapping(value = "/{id}") 
	public ResponseEntity<User> findById(@PathVariable Long id)
	{
		User obj = userService.findById(id);
		
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user)
	{
		User newUser = userService.insert(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		
		return ResponseEntity.created(uri).body(newUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id)
	{
		userService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
