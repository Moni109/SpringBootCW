package com.example.question2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.question2.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    
   List<Product> findByProductNameStartingWith(String productName);
   
   List<Product> findByProductNameEndingWith(String productName);

} 
