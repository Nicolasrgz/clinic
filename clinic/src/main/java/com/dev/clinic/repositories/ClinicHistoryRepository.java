package com.dev.clinic.repositories;

import com.dev.clinic.models.ClinicHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClinicHistoryRepository extends JpaRepository<ClinicHistory, Long> {
}
