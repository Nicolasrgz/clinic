package com.dev.clinic.controllers;


import com.dev.clinic.dtos.PatientDTO;
import com.dev.clinic.dtos.RegisterPatientDTO;
import com.dev.clinic.models.Patient;
import com.dev.clinic.repositories.PatientRepository;
import com.dev.clinic.services.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<PatientDTO>getPatients(){
        return patientService.getPatients();
    }

    @PostMapping("/patient/register")
    public ResponseEntity<Object> patientRegister(@RequestBody RegisterPatientDTO registerPatientDTO){

        if (registerPatientDTO.getName().isBlank()){
            return new ResponseEntity<>("The name field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getLastName().isBlank()){
            return new ResponseEntity<>("The last name field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getAge() == null){
            return new ResponseEntity<>("The age field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getDni() == null){
            return new ResponseEntity<>("The DNI field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getDni() < 0){
            return new ResponseEntity<>("The DNI must be greater than or equal to 0", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getPassword().isBlank()){
            return new ResponseEntity<>("The password field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getPassword().length() < 8){
            return new ResponseEntity<>("The password must be at least 8 characters long", HttpStatus.FORBIDDEN);
        }
        if (patientService.findByEmail(registerPatientDTO.getEmail()) != null) {
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }
        if (registerPatientDTO.getEmail().isBlank()) {
            return new ResponseEntity<>("The email field is incomplete", HttpStatus.FORBIDDEN);
        }

        Patient patient = new Patient(registerPatientDTO.getName(), registerPatientDTO.getLastName(), registerPatientDTO.getDni(), registerPatientDTO.getAge(), registerPatientDTO.getEmail(), registerPatientDTO.getPassword());
        patientService.savePatient(patient);

        return ResponseEntity.ok().build();
    }



}
