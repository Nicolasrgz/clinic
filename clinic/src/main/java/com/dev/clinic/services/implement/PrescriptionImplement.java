package com.dev.clinic.services.implement;

import com.dev.clinic.dtos.PrescriptionDTO;
import com.dev.clinic.repositories.PrescriptionRepository;
import com.dev.clinic.services.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionImplement implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public List<PrescriptionDTO> getPrescriptions() {
        return prescriptionRepository.findAll().stream().map(PrescriptionDTO::new).collect(Collectors.toList());
    }
}
