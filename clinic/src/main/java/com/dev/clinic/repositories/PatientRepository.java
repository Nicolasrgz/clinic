package com.dev.clinic.repositories;

import com.dev.clinic.models.ClinicHistory;
import com.dev.clinic.models.Medic;
import com.dev.clinic.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByEmail(String email);
    Patient findByDni(Integer dni);
}
