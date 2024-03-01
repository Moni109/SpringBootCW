package com.example.question1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.model.Address;
import com.example.question1.service.AddressService;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/address/person/{personId}")
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address add = addressService.postDetails(address); 
        if(add!=null){
            return new ResponseEntity<>(add,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(add,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
