package com.example.nttdata.service;

import java.util.Optional;

import com.example.nttdata.model.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
	
	public Mono<Product> save(Product product);
	
	public Flux<Product> findAll();
	
	public Mono<Product> findById(String id);
	
	public void deleteById(String id);
	
	public Optional<Double> getBalance(Long accountNumber);
	
	public Optional<Double> getCreditLimit(Long accountNumber);
	
	public Optional<String> getType(Long accountNumber);
}
