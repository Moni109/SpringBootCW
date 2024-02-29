package com.example.question1.service;

import org.springframework.stereotype.Service;

import com.example.question1.model.Product;
import com.example.question1.repository.ProductRepo;

@Service
public class ProductService {
     private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public boolean saveProducts(Product product){
        if(product!=null){
            productRepo.save(product);
            return true;
        }
        return false;

    } 
    
    public boolean updateproducts(int id, Product product){
        boolean p = productRepo.existsById(id);
        if(p){
            productRepo.save(product);
            return true;
        }
        return false;
    }

    public boolean deleteproducts(int id, Product product){
        boolean p = productRepo.existsById(id);
        if(p){
            productRepo.delete(product);
            return true;
        }
        return false;
    }
}
