package com.dev.clinic.services.implement;


import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.services.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class MedicImplement implements MedicService {

    @Autowired
    private MedicRepository medicRepository;

    @Override
    public List<MedicDTO> getMedics() {
        return medicRepository.findAll().stream().map(MedicDTO::new).collect(Collectors.toList());
    }
}
