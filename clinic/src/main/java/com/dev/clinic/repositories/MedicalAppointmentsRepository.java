package com.dev.clinic.repositories;

import com.dev.clinic.models.MedicalAppointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedicalAppointmentsRepository extends JpaRepository<MedicalAppointments, Long> {
}
