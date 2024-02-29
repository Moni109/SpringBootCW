package com.example.question3.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.question3.model.Product;
import com.example.question3.repository.ProductRepo;

@Service
public class ProductService {
    private ProductRepo productRepo;
    public ProductService(ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> getProductPage(int offset, int pagesize){
        Pageable pageable = PageRequest.of(offset, pagesize);
        Page<Product> page=productRepo.findAll(pageable);
        return page.getContent();
    }

    public List<Product> productSortedPage(int offset, int pagesize, String fiels){
        Pageable pageable = PageRequest.of(offset, pagesize, Sort.by(fiels));
        Page<Product> page = productRepo.findAll(pageable);
        return page.getContent();
    }

    public Product productId(int id){
        return productRepo.findById(id).orElse(null);
    }
}
