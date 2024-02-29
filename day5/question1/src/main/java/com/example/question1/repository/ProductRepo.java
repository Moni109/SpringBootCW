package com.example.question1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question1.model.Product;

public interface ProductRepo extends JpaRepository<Product,Integer> {

}
