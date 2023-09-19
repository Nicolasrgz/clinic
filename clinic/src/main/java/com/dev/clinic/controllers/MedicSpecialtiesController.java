package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicalSpecialtiesDTO;
import com.dev.clinic.models.MedicalSpecialties;
import com.dev.clinic.repositories.MedicalSpecialtiesRepository;
import com.dev.clinic.services.service.MedicSpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicSpecialtiesController {

    @Autowired
    private MedicSpecialtiesService medicSpecialtiesService;
    @Autowired
    private MedicalSpecialtiesRepository medicalSpecialtiesRepository;


    @GetMapping("/specialties")
    public List<MedicalSpecialtiesDTO>getMedicalSpecialties(){
        return medicSpecialtiesService.getSpecialties();
    }

    @PostMapping("/specialties/created")
    public ResponseEntity<Object> createdSpecialties(@RequestBody MedicalSpecialtiesDTO medicalSpecialtiesDTO){
        if (medicalSpecialtiesDTO.getName().isBlank()){
            return new ResponseEntity<>("the specialty field is incomplete", HttpStatus.FORBIDDEN);
        }
        String name = medicalSpecialtiesDTO.getName();
        if (name.split("\\s+").length > 1) {
            return new ResponseEntity<>("The specialty name must be a single word", HttpStatus.BAD_REQUEST);
        }

        String nameInLowerCase = medicalSpecialtiesDTO.getName().toLowerCase();
        if (medicSpecialtiesService.findByName(nameInLowerCase) != null){
            return new ResponseEntity<>("The specialty already exists", HttpStatus.BAD_REQUEST);
        }

        if (medicalSpecialtiesDTO.getDescription().isBlank()){
            return new ResponseEntity<>("The description field is incomplete", HttpStatus.FORBIDDEN);
        }

        MedicalSpecialties medicalSpecialties = new MedicalSpecialties(medicalSpecialtiesDTO.getName(), medicalSpecialtiesDTO.getDescription());
        medicSpecialtiesService.saveMedicalSpecialty(medicalSpecialties);

        return ResponseEntity.ok().build();
    }

}
