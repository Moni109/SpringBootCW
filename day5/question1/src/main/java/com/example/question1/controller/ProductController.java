package com.example.question1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.model.Product;
import com.example.question1.service.ProductService;

@RestController
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> getProduct(@RequestBody Product product){
        boolean pro = productService.saveProducts(product);
        if(!pro){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }

    @PutMapping("/updateproducts/{productid}")
    public ResponseEntity<Product> updateProductbyid(@PathVariable ("productid") int id, @RequestBody Product products){
        if(productService.updateproducts(id,products)){
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
        return new ResponseEntity<>(products,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("deleteproducts/{productid}")
    public ResponseEntity<Product> deleteProductbyid(@PathVariable ("productid") int id,@RequestBody Product product){
        if(productService.deleteproducts(id,product)){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(product,HttpStatus.NOT_FOUND);
    }
}
