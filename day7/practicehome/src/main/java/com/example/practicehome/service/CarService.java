package com.example.practicehome.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.practicehome.model.Car;
import com.example.practicehome.repository.CarRepo;

@Service
public class CarService {
    private CarRepo carRepo;
    public CarService(CarRepo carRepo){
        this.carRepo=carRepo;
    }

    public Car postCar(Car car){
        return carRepo.save(car);
    }

    public List<Car> getCarDetails(){
        return carRepo.findAll();
    }

    public Car findByOwnerNameAndAddress(String currentOwnerName, String address){
        return carRepo.getByNameAngAddress(currentOwnerName, address);
    }

}
