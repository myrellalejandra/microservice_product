package com.example.nttdata.controller;

import java.util.Optional;

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
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public Mono<Product> save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@GetMapping("/product")
	public Flux<Product> findAll(){
		return productService.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Mono<Product> findById(@PathVariable String id){
		return productService.findById(id);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteById(@PathVariable String id){
		productService.deleteById(id);
	}
	
	@PutMapping("/product")
	public Mono<Product> update(@RequestBody Product product){
		 return productService.save(product);
	}
	
	@GetMapping("/balanceByAccount/{accountNumber}")
	public Optional<Double> getBalance(@PathVariable Long accountNumber) {
		return productService.getBalance(accountNumber);
		
	}
	
	@GetMapping("/creditLimitByAccount/{accountNumber}")
	public Optional<Double> getCreditLimit(@PathVariable Long accountNumber){
		return productService.getCreditLimit(accountNumber);
	}
	
	//
	/*@GetMapping("/creditLimitByAccount/{accountNumber}")
	public Mono<Product> findById(@PathVariable String id){
		return productService.findById(id);
	}
	
	@GetMapping("/creditLimitByAccount/{accountNumber}")
	public Mono<Product> findById(@PathVariable String id){
		return productService.findById(id);
	}*/
}
	
