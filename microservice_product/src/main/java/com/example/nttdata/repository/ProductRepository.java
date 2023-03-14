package com.example.nttdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nttdata.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
