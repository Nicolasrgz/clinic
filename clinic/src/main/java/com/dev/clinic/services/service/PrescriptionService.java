package com.dev.clinic.services.service;

import com.dev.clinic.dtos.PrescriptionDTO;

import java.util.List;

public interface PrescriptionService {

    List<PrescriptionDTO>getPrescriptions();
}
