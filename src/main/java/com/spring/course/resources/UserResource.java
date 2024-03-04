package com.spring.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.course.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource
{
	@GetMapping
	public ResponseEntity<User> findAll()
	{
		User u = new User(1L, "Lucas", "lucas@email.com", "3333-3333", "12345");
		
		return ResponseEntity.ok(u);
	}
}
