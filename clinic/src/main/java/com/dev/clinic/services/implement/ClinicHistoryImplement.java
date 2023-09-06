package com.dev.clinic.services.implement;

import com.dev.clinic.dtos.ClinicHistoryDTO;
import com.dev.clinic.models.ClinicHistory;
import com.dev.clinic.repositories.ClinicHistoryRepository;
import com.dev.clinic.services.service.ClinicHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicHistoryImplement implements ClinicHistoryService {

    @Autowired
    private ClinicHistoryRepository clinicHistoryRepository;

    @Override
    public List<ClinicHistoryDTO> getClinicHistories() {
        return clinicHistoryRepository.findAll().stream().map(ClinicHistoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public void saveClinicHistory(ClinicHistory clinicHistory) {
        clinicHistoryRepository.save(clinicHistory);
    }
}
