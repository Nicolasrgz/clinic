package com.dev.clinic.services.service;

import com.dev.clinic.dtos.MedicDTO;
import com.dev.clinic.models.Medic;

import java.util.List;

public interface MedicService {

    List<MedicDTO>getMedics();
    void saveMedic (Medic medic);
    Medic findByRegistrationNumber (String registrationNumber);
    Medic findByEmail(String email);
}
