package com.example.question2.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.question2.model.Product;
import com.example.question2.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public Product savedProducts(Product product){
        return productRepo.save(product);
    }

    public List<Product> getStartingName(String name){
        return productRepo.findByProductNameStartingWith(name + "%");
    }
    public List<Product> getEndingName(String name){
        return productRepo.findByProductNameEndingWith("%" + name);
    }

    public List<Product> sortByField(String field){
        return productRepo.findAll(Sort.by(field));
    }
}
