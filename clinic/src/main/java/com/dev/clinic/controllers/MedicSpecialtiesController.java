package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicalSpecialtiesDTO;
import com.dev.clinic.services.service.MedicSpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicSpecialtiesController {

    @Autowired
    private MedicSpecialtiesService medicSpecialtiesService;

    @GetMapping("/specialties")
    public List<MedicalSpecialtiesDTO>getMedicalSpecialties(){
        return medicSpecialtiesService.getSpecialties();
    }

}
