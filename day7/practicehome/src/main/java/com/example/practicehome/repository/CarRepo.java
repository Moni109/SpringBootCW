package com.example.practicehome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.practicehome.model.Car;

public interface CarRepo extends JpaRepository<Car,Integer> {
    @Query("SELECT distinct c FROM Car c where c.currentOwnerName = currentOwnerName AND c.address=address")
    Car getByNameAngAddress(String currentOwnerName, String address);
}
