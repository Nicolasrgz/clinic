package com.dev.clinic.controllers;

import com.dev.clinic.dtos.PrescriptionDTO;
import com.dev.clinic.services.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/prescriptions")
    public List<PrescriptionDTO>getPrescriptions(){
        return prescriptionService.getPrescriptions();
    }
}
