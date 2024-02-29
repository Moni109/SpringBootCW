package com.example.question3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question3.model.Product;
import com.example.question3.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
     private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> getProduct(@RequestBody Product product){
        boolean pro = productService.saveProducts(product);
        if(!pro){
            return new ResponseEntity<>(product,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> p=productService.getProducts();
        if(p!=null){
            return new ResponseEntity<>(p,HttpStatus.OK);
        }
        return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{productId}")
    public Product getProductID(@PathVariable int productId){
        Optional<Product> p=productService.getProductsById(productId);
        if(p!=null){
            // return new ResponseEntity<>(p,HttpStatus.OK);
            return p.get();
        }
        // return new ResponseEntity<>(p,HttpStatus.NOT_FOUND);
        return null;
    }
    
}
