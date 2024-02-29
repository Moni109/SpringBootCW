package com.example.question1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.question1.model.Medicine;
import com.example.question1.repository.MedicineRepo;

@Service
public class MedicineService {
     private MedicineRepo medicineRepo;
    public MedicineService(MedicineRepo medicineRepo){
        this.medicineRepo=medicineRepo;
    }
    public Medicine saveMedicineList(Medicine medicine){
        return medicineRepo.save(medicine);
    }

    public List<Medicine> getMedicines(){
        return medicineRepo.findAll();
    }

    public Medicine getMedicineId(int id){
        // Optional<Medicine> obj=medicineRepo.findById(id);
        // return obj.orElse(null);
        return medicineRepo.findById(id).orElse(null);
    }
}
