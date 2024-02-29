package com.example.question3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.question3.model.Door;

public interface DoorRepo extends JpaRepository<Door,Integer> {

    @Query("SELECT d FROM Door d where d.doorId=?1")
    List<Door> findByDoorId(int doorId);
    
    @Query("SELECT d FROM Door d where d.accessType=?1")
    List<Door> findByAccessType(String accessType);
}