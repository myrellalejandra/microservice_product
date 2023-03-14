package com.example.nttdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nttdata.model.Product;
import com.example.nttdata.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/postProduct")
	public void save(@RequestBody Product product) {
		productService.save(product);
	}
	
	@GetMapping("/getProduct")
	public List<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/finByIdProduct/{id}")
	public Product findById(@PathVariable String id){
		return productService.findById(id).get();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteById(@PathVariable String id){
		productService.deleteById(id);
	}
	
	@PutMapping("/updateProduct")
	public void update(@RequestBody Product product){
		 productService.save(product);
	}
	
}