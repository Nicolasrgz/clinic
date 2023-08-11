package com.dev.clinic.repositories;

import com.dev.clinic.models.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
