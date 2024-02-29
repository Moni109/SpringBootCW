package com.example.question1.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.question1.model.Medicine;
import com.example.question1.service.MedicineService;

@RestController
public class MedicineController {
     private MedicineService medicineService;
    public MedicineController(MedicineService medicineService){
        this.medicineService=medicineService;
    }
    @PostMapping("/medicine")
    public ResponseEntity<Medicine> listMedicine(@RequestBody Medicine medicine){
        Medicine savedMedicine = medicineService.saveMedicineList(medicine);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedicine);
    }
    @GetMapping("/medicines")
    public List<Medicine> lMedicines() {
        return medicineService.getMedicines();
    }


    @GetMapping("/medicines/{id}")
    public Medicine getbyId(@PathVariable ("id") int id) {
        return medicineService.getMedicineId(id);
    }
}
