package com.dev.clinic.services.service;

import com.dev.clinic.dtos.ClinicHistoryDTO;
import com.dev.clinic.models.ClinicHistory;

import java.util.List;

public interface ClinicHistoryService {

    List<ClinicHistoryDTO>getClinicHistories();

    void saveClinicHistory(ClinicHistory clinicHistory);
}
