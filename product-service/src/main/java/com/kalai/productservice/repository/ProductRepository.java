package com.kalai.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kalai.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product,String>{

    
} 
