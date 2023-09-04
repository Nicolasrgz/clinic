package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.dtos.RegisterMedicDTO;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.services.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @GetMapping("/medics")
    public List<MedicDTO> getMedics(){
        return medicService.getMedics();
    }

    @PostMapping("/medic/register")
    public ResponseEntity<Object> registerMedic(@RequestBody RegisterMedicDTO registerMedicDTO){

        if (registerMedicDTO.getName().isBlank()){
            return new ResponseEntity<>("The name field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getLastName().isBlank()){
            return new ResponseEntity<>("The last name field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getAge() == null){
            return new ResponseEntity<>("The age field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getAge() < 25){
            return new ResponseEntity<>("The age must be greater than or equal to 25", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getPassword().isBlank()){
            return new ResponseEntity<>("The password field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getPassword().length() < 8){
            return new ResponseEntity<>("The password must be at least 8 characters long", HttpStatus.FORBIDDEN);
        }





        return ResponseEntity.ok().build();
    }


}
