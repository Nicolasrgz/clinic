package com.dev.clinic.services.implement;

import com.dev.clinic.dtos.MedicalSpecialtiesDTO;
import com.dev.clinic.models.MedicalSpecialties;
import com.dev.clinic.repositories.MedicalSpecialtiesRepository;
import com.dev.clinic.services.service.MedicSpecialtiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicSpecialtiesImplement implements MedicSpecialtiesService {

    @Autowired
    private MedicalSpecialtiesRepository medicalSpecialtiesRepository;

    @Override
    public List<MedicalSpecialtiesDTO> getSpecialties() {
        return medicalSpecialtiesRepository.findAll().stream().map(MedicalSpecialtiesDTO::new).collect(Collectors.toList());
    }
}
