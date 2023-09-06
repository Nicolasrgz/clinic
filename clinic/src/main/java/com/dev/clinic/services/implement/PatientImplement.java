package com.dev.clinic.services.implement;

import com.dev.clinic.dtos.PatientDTO;
import com.dev.clinic.models.Patient;
import com.dev.clinic.repositories.PatientRepository;
import com.dev.clinic.services.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientImplement implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<PatientDTO> getPatients() {
        return patientRepository.findAll().stream().map(PatientDTO::new).collect(Collectors.toList());
    }

    @Override
    public Patient findByEmail(String email) {
        return patientRepository.findByEmail(email);
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findByDni(Integer dni) {
        return patientRepository.findByDni(dni);
    }
}
