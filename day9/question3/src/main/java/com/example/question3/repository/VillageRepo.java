package com.example.question3.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.question3.model.Village;

public interface VillageRepo extends CrudRepository<Village, Integer> {

    Village findByVillageName(String villageName);

    Village findByVillagePopulation(int villagePopulation);
}