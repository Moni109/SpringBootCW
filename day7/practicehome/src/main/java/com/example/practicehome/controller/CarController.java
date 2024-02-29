package com.example.practicehome.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practicehome.model.Car;
import com.example.practicehome.service.CarService;

@RestController
@RequestMapping("/api/car")
public class CarController {
    private CarService carService;
    public CarController(CarService carService){
        this.carService=carService;
    }
    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        Car c = carService.postCar(car);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(c,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping
    public ResponseEntity<List<Car>> getCar(){
        List<Car> c = carService.getCarDetails();
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("/distinct/{currentOwnerName}/{address}")
    public ResponseEntity<Car> getDistinct(@PathVariable String currentOwnerName,@PathVariable String address){
        Car c = carService.findByOwnerNameAndAddress(currentOwnerName,address);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
