package com.example.nttdata.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nttdata.model.Product;
import com.example.nttdata.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private final ProductRepository productRepository = null;
	
	public Mono<Product> save(Product product) {
		return productRepository.save(product);
	}
	
	public Flux<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Mono<Product> findById(String id) {
		return productRepository.findById(id);
	}
	
	public void deleteById(String id) {
		productRepository.deleteById(id).subscribe();
	}
	
	public Optional<Double> getBalance(Long accountNumber) {
		return productRepository.findBalanceByAccountNumber(accountNumber)
				.map(Product::getBalance);
	}
	
	public Optional<Double> getCreditLimit(Long accountNumber) {
		return getType(accountNumber)
				.filter(type -> type.equals("creditcard"))
				.flatMap(type -> productRepository.findCreditLimit(accountNumber))
				.map(Product::getCreditLimit);					
	}
	
	//Get product type 
	public Optional<String> getType(Long accountNumber){
		return productRepository.findProductType(accountNumber)
				.map(Product::getType);
	}
	
}
