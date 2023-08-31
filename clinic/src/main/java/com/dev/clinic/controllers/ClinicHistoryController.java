package com.dev.clinic.controllers;

import com.dev.clinic.dtos.ClinicHistoryDTO;
import com.dev.clinic.services.service.ClinicHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClinicHistoryController {

    @Autowired
    private ClinicHistoryService clinicHistoryService;

    @GetMapping("histories")
    public List<ClinicHistoryDTO>getClinicHistories(){
        return clinicHistoryService.getClinicHistories();
    }

}
