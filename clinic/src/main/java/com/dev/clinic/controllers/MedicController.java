package com.dev.clinic.controllers;

import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.repositories.MedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MedicController {

    @Autowired
    private MedicRepository medicRepository;

    @GetMapping("/medics")
    public List<MedicDTO> getMedics(){
        return medicRepository.findAll().stream().map(MedicDTO::new).collect(Collectors.toList());
    }

}
