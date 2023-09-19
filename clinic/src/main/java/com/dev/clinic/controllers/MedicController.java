package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.dtos.RegisterMedicDTO;
import com.dev.clinic.models.Medic;
import com.dev.clinic.models.MedicalSpecialties;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.repositories.MedicalSpecialtiesRepository;
import com.dev.clinic.services.service.MedicService;
import com.dev.clinic.services.service.MedicSpecialtiesService;
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
    @Autowired
    private MedicSpecialtiesService medicSpecialtiesService;

    @GetMapping("/medics")
    public List<MedicDTO> getMedics(){
        return medicService.getMedics();
    }

    @PostMapping("/medic/register")
    public ResponseEntity<Object> registerMedic(@Validated@RequestBody RegisterMedicDTO registerMedicDTO){

        if (registerMedicDTO.getNameSpecialty().isBlank()){
            return new ResponseEntity<>("the specialty field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerMedicDTO.getDescription().isBlank()){
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
        if (medicService.findByEmail(registerMedicDTO.getEmail()) != null){
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
        } while(medicService.findByRegistrationNumber(registrationNumber) != null);

        // falta encriptar contraseñas
        Medic medic = new Medic(registerMedicDTO.getName(), registerMedicDTO.getLastName(), registerMedicDTO.getAge(), registerMedicDTO.getEmail(), registrationNumber, registerMedicDTO.getPassword());

        MedicalSpecialties medicalSpecialties = medicSpecialtiesService.findByName(registerMedicDTO.getNameSpecialty());
        //Esta es una declaración condicional que verifica si medicalSpecialties es null. Si es null, significa que no se encontró ninguna especialidad con el nombre proporcionado en la base de datos.
        if (medicalSpecialties == null) {
            medicalSpecialties = new MedicalSpecialties(registerMedicDTO.getNameSpecialty(), registerMedicDTO.getDescription());
            medicSpecialtiesService.saveMedicalSpecialty(medicalSpecialties);
        }

        medic.addMedicalSpecialty(medicalSpecialties);
        medicalSpecialties.addMedic(medic);

        medicService.saveMedic(medic);

        return ResponseEntity.ok().build();
    }

}
