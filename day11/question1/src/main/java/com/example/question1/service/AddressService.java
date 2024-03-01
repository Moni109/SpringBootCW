package com.example.question1.service;

import org.springframework.stereotype.Service;

import com.example.question1.model.Address;
import com.example.question1.repository.AddressRepository;


@Service
public class AddressService {
   private AddressRepository addressRepository;
   public AddressService(AddressRepository addressRepository){
    this.addressRepository=addressRepository;
   }

    public Address postDetails(Address address){
        return addressRepository.save(address);
    }

}
