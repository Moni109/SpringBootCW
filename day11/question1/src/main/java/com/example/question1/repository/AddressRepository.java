package com.example.question1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.question1.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {

     
} 

