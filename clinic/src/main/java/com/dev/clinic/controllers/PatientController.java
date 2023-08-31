package com.dev.clinic.controllers;


import com.dev.clinic.dtos.PatientDTO;
import com.dev.clinic.services.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<PatientDTO>getPatients(){
        return patientService.getPatients();
    }

}
