package com.example.question3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.question3.model.Door;
import com.example.question3.repository.DoorRepo;

@Service
public class DoorService {
    private DoorRepo doorRepo;
    public DoorService(DoorRepo doorRepo){
        this.doorRepo=doorRepo;
    }

    public Door postDoor(Door door){
        return doorRepo.save(door);
    }

    public List<Door> getDoors(){
        return doorRepo.findAll();
    }

    public List<Door> findDoorId(int doorId){
        return doorRepo.findByDoorId(doorId);
    }

    public List<Door> findDoorType(String accessType){
        return doorRepo.findByAccessType(accessType);
    }

}
