package com.dev.clinic.services.service;

import com.dev.clinic.dtos.PrescriptionDTO;
import com.dev.clinic.models.Prescription;

import java.util.List;

public interface PrescriptionService {

    List<PrescriptionDTO>getPrescriptions();
    void savePrescription (Prescription prescription);
}
