package com.dev.clinic.controllers;

import com.dev.clinic.dtos.PrescriptionDTO;
import com.dev.clinic.repositories.ClinicHistoryRepository;
import com.dev.clinic.repositories.PrescriptionRepository;
import com.dev.clinic.services.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private ClinicHistoryRepository clinicHistoryRepository;

    @GetMapping("/prescriptions")
    public List<PrescriptionDTO>getPrescriptions(){
        return prescriptionService.getPrescriptions();
    }

    @PostMapping("/prescription/created")
    public ResponseEntity<Object> createdPrescription(){



        return  ResponseEntity.ok().build();
    }
}
