package com.dev.clinic.services.service;

import com.dev.clinic.dtos.MedicalSpecialtiesDTO;
import com.dev.clinic.models.MedicalSpecialties;

import java.util.List;

public interface MedicSpecialtiesService {

    List<MedicalSpecialtiesDTO> getSpecialties();

    MedicalSpecialties findByName(String name);
    void saveMedicalSpecialty(MedicalSpecialties medicalSpecialties);
}
