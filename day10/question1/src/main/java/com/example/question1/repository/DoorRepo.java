package com.example.question1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.question1.model.Door;


public interface DoorRepo extends JpaRepository<Door,Integer>{
    @Query("select d from Door d where d.doorType=?1")
    public List<Door> findByDoorType(String doorType);
    @Query("select d from Door d where d.color=?1")
    public List<Door> findByColor(String color);
}
