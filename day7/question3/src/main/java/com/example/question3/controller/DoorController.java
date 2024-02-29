package com.example.question3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question3.model.Door;
import com.example.question3.service.DoorService;

@RestController
@RequestMapping("/api/door")
public class DoorController {
    private DoorService doorService;
    public DoorController(DoorService doorService){
        this.doorService=doorService;
    }

    @PostMapping
    public ResponseEntity<Door> createDoor(@RequestBody Door door){
        if(doorService.postDoor(door)!=null){
            return new ResponseEntity<>(door,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(door,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping
        public ResponseEntity<List<Door>> getDoor(){
            List<Door> d=doorService.getDoors();
            if(d!=null){
                return new ResponseEntity<>(d,HttpStatus.OK);
            }
            return new ResponseEntity<>(d,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
     @GetMapping("/{doorId}")
    public ResponseEntity<List<Door>> findByDoorId(@PathVariable int doorId){
        List<Door> d=doorService.findDoorId(doorId);
        if(d!=null){
            return new ResponseEntity<>(d,HttpStatus.OK);
        }
        return new ResponseEntity<>(d,HttpStatus.INTERNAL_SERVER_ERROR);
    }
     @GetMapping("/accesstype/{accessType}")
    public ResponseEntity<List<Door>> findByDoorType(@PathVariable String accessType){
        List<Door> d=doorService.findDoorType(accessType);
        if(d!=null){
            return new ResponseEntity<>(d,HttpStatus.OK);
        }
        return new ResponseEntity<>(d,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
