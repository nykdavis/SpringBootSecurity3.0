package com.example.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.dto.Product;
import com.example.spring.security.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this end pointis not secure";
	}
	
	@GetMapping("/all")
	public List<Product> getAllTheProduct(){
		return service.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}

}
