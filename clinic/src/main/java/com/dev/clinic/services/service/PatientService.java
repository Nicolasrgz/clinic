package com.dev.clinic.services.service;

import com.dev.clinic.dtos.PatientDTO;
import com.dev.clinic.models.Medic;
import com.dev.clinic.models.Patient;

import java.util.List;

public interface PatientService {

    List<PatientDTO>getPatients();
    Patient findByEmail(String email);
    void savePatient(Patient patient);
    Patient findByDni(Integer dni);


}
