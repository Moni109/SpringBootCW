package com.example.question1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.model.Door;
import com.example.question1.service.DoorService;



@RestController
@RequestMapping("/api/door")

public class DoorController {
    @Autowired
    DoorService doorService;
    @PostMapping
    public ResponseEntity<Door> getMethodName(@RequestBody Door door) {
        return new ResponseEntity<>(doorService.saveDoor(door), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Door> getMethodName1() {
        return doorService.getDoor();
    }

    @GetMapping("/bycolor/{color}")
    public List<Door> getDoorByColor(@PathVariable String color) {
        return getDoorByColor(color);
    }
    
    
    @GetMapping("/bydoortype")
    public List<Door> getMethodName2(@RequestParam String doorType) {
        return doorService.getDoorByType(doorType);
    }

    @GetMapping("/{doorId}")
    public Door getMethodName3(@PathVariable int doorId) {
        return doorService.getDoor(doorId);
    }
    
    @PutMapping("/{doorId}")
    public Door updateDoor(@PathVariable int doorId, @RequestParam String color) {
        return doorService.updateDoor(doorId, color);
    }

    @DeleteMapping("/{doorId}")
    public String deleteDoor(@PathVariable int doorId){
        if(doorService.getDoor(doorId) == null){
            return "Door not found";
        }
        else{
            doorService.deleteDoor(doorId);
            return "Door deleted successfully";
        }
    }



    
    
    
}