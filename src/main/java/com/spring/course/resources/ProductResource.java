package com.spring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.course.entities.Product;
import com.spring.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource
{
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll()
	{
		return ResponseEntity.ok(productService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id)
	{
		Product obj = productService.findById(id);
		
		return ResponseEntity.ok(obj);
	}
}
