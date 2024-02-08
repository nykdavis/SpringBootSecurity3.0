package com.example.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.dto.Product;
import com.example.spring.security.entity.UserInfo;
import com.example.spring.security.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	/*
	 * Anyone can access without authentication
	 */
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this end pointis not secure";
	}
	
	/*
	 * Its a method to create user
	 * Anyone can create the user without Authentication
	 */
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}
	
	
	/*
	 * This method call be accessed by the admin only
	 */
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllTheProduct(){
		return service.getProducts();
	}
	
	
	/*
	 * This method call be accessed by the user only
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}

}
