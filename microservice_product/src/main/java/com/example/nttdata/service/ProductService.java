package com.example.nttdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nttdata.model.Product;
import com.example.nttdata.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
@AllArgsConstructor
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(String id) {
		return productRepository.findById(id);
	}
	
	public void deleteById(String id) {
		productRepository.deleteById(id);
	}
}
