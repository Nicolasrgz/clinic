package com.dev.clinic.repositories;

import com.dev.clinic.models.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicRepository extends JpaRepository<Medic, Long> {

    Medic findByRegistrationNumber (String registrationNumber);
    Medic findByEmail(String email);

}
