package com.example.nttdata.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.nttdata.model.Product;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    @Query(value="{ 'accountNumber' : ?0 }", fields="{ 'balance' : 1 }")
    Optional<Product> findBalanceByAccountNumber(Long accountNumber);
    
    @Query(value="{ 'accountNumber' : ?0 }", fields="{ 'creditLimit' : 1 }")
    Optional<Product> findCreditLimit(Long accountNumber);
    
    @Query(value="{ 'accountNumber' : ?0 }", fields="{ 'type' : 1 }")
    Optional<Product> findProductType(Long accountNumber);
    
}

