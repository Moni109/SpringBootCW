package com.example.question4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question4.model.Address;

@RestController
public class AddressController {
    @GetMapping("/address")
    public Address getAddressModel(){
        Address a=new Address(null, 123, "Main st", 0, null, null, null, null);
        return a;
    }
}