package com.example.question2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question2.model.Product;
import com.example.question2.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(Product product){
        Product p = productService.savedProducts(product);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/distinct/startwith/{name}")
    public ResponseEntity<List<Product>> getStartName(@PathVariable String name){
        List<Product> p = productService.getStartingName(name);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    @GetMapping("/distinct/endwith/{name}")
    public ResponseEntity<List<Product>> getEndName(@PathVariable String name){
        List<Product> p = productService.getEndingName(name);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);
        
    }
    
    @GetMapping("/sortBy/{price}")
    public ResponseEntity<List<Product>> getByField(@PathVariable String price){
        List<Product> p = productService.sortByField(price);
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.INTERNAL_SERVER_ERROR);

    }


}
