package com.example.question1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.question1.model.Door;
import com.example.question1.repository.DoorRepo;


@Service
public class DoorService {
    @Autowired
    private DoorRepo doorRepo;
    public Door saveDoor(Door door){
        return doorRepo.save(door);
    }
    public List<Door> getDoor(){
        return doorRepo.findAll();
    }

    public Door getDoor(int id){
        return doorRepo.findById(id).orElse(null);
    }

    public List<Door> getDoorByType(String doorType){
        return doorRepo.findByDoorType(doorType);
    }

    public void deleteDoor(int id){
        doorRepo.deleteById(id);
    }

    public List<Door> getDoorByColor(String color){
        return doorRepo.findByColor(color);
    }

    public Door updateDoor(int doorId, String color){
        Door door = doorRepo.findById(doorId).orElse(null);
        if(door == null){
            return null;
        }
        door.setColor(color);
        return doorRepo.save(door);
    }


}

