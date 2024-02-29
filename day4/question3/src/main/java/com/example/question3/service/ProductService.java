package com.example.question3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.question3.model.Product;
import com.example.question3.repository.ProductRepo;

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
    
    public List<Product> getProducts(){
        return productRepo.findAll();
    }
    
    public Optional<Product> getProductsById(int id){

        return productRepo.findById(id);
    }
}
