package com.dev.clinic.repositories;

import com.dev.clinic.models.MedicalSpecialties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicalSpecialtiesRepository extends JpaRepository<MedicalSpecialties, Long > {

    MedicalSpecialties findByName(String name);
}
