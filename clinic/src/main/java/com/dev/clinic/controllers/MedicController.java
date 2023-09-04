package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.dtos.RegisterMedicDTO;
import com.dev.clinic.models.Medic;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.services.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @Autowired
    private MedicRepository medicRepository;

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

        String registrationNumber;
        do {
            registrationNumber = "ABC-" + (long) ((Math.random() * (99999999 - 10000000)) + 10000000);
        }while(medicRepository.findByRegistrationNumber(registrationNumber) != null);

        //falta encriptar contraseñas
        Medic medic = new Medic(registerMedicDTO.getName(), registerMedicDTO.getLastName(), registerMedicDTO.getAge(), registerMedicDTO.getEmail(), registrationNumber, registerMedicDTO.getPassword());
        medicRepository.save(medic);

        return ResponseEntity.ok().build();
    }


}
