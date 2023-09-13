package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.dtos.RegisterMedicDTO;
import com.dev.clinic.models.Medic;
import com.dev.clinic.models.MedicalSpecialties;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.repositories.MedicalSpecialtiesRepository;
import com.dev.clinic.services.service.MedicService;
import com.dev.clinic.utils.MedicUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicController {

    @Autowired
    private MedicService medicService;

    @Autowired
    private MedicRepository medicRepository;
    @Autowired
    private MedicalSpecialtiesRepository medicalSpecialtiesRepository;
    @GetMapping("/medics")
    public List<MedicDTO> getMedics(){
        return medicService.getMedics();
    }

    @PostMapping("/medic/register")
    public ResponseEntity<Object> registerMedic(@Validated@RequestBody RegisterMedicDTO registerMedicDTO, @RequestParam String nameSpecialty, @RequestParam String description){

        if (nameSpecialty.isBlank()){
            return new ResponseEntity<>("the specialty field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (description.isBlank()){
            return new ResponseEntity<>("the description field is incomplete", HttpStatus.FORBIDDEN);
        }


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
        if (registerMedicDTO.getEmail().isBlank()){
            return new ResponseEntity<>("The Email field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (medicRepository.findByEmail(registerMedicDTO.getEmail()) != null){
            return new ResponseEntity<>("The email is in use, please select another", HttpStatus.FORBIDDEN);
        }

        if (registerMedicDTO.getPassword().isBlank()){
            return new ResponseEntity<>("The password field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getPassword().length() < 8){
            return new ResponseEntity<>("The password must be at least 8 characters long", HttpStatus.FORBIDDEN);
        }

        String registrationNumber;
        do {
            registrationNumber = MedicUtils.getRegistrationNumber();
        }while(medicService.findByRegistrationNumber(registrationNumber) != null);

        //falta encriptar contraseñas
        Medic medic = new Medic(registerMedicDTO.getName(), registerMedicDTO.getLastName(), registerMedicDTO.getAge(), registerMedicDTO.getEmail(), registrationNumber, registerMedicDTO.getPassword());
        MedicalSpecialties medicalSpecialties = new MedicalSpecialties(nameSpecialty, description);
        medic.addMedicalSpecialty(medicalSpecialties);
        medicService.saveMedic(medic);
        medicalSpecialtiesRepository.save(medicalSpecialties);

        return ResponseEntity.ok().build();
    }

}
