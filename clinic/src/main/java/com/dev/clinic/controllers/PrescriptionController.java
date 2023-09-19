package com.dev.clinic.controllers;

import com.dev.clinic.dtos.PrescriptionCreatedDTO;
import com.dev.clinic.dtos.PrescriptionDTO;
import com.dev.clinic.models.Medic;
import com.dev.clinic.models.Patient;
import com.dev.clinic.models.Prescription;
import com.dev.clinic.repositories.ClinicHistoryRepository;
import com.dev.clinic.repositories.MedicRepository;
import com.dev.clinic.repositories.PatientRepository;
import com.dev.clinic.repositories.PrescriptionRepository;
import com.dev.clinic.services.service.MedicService;
import com.dev.clinic.services.service.PatientService;
import com.dev.clinic.services.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private ClinicHistoryRepository clinicHistoryRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private MedicRepository medicRepository;
    @Autowired
    private MedicService medicService;

    @GetMapping("/prescriptions")
    public List<PrescriptionDTO>getPrescriptions(){
        return prescriptionService.getPrescriptions();
    }

    @Transactional
    @PostMapping("/prescription/created")
    public ResponseEntity<Object> createdPrescription(@Validated@RequestBody PrescriptionCreatedDTO prescriptionCreatedDTO){

        if (prescriptionCreatedDTO.getDni() == null){
            return new ResponseEntity<>("The DNI field is incomplete", HttpStatus.FORBIDDEN);
        }
        if (prescriptionCreatedDTO.getRegistrationNumber().isBlank()){
            return new ResponseEntity<>("The registration number field is incomplete", HttpStatus.FORBIDDEN);
        }

        Patient patient = patientService.findByDni(prescriptionCreatedDTO.getDni());
        Medic medic = medicService.findByRegistrationNumber(prescriptionCreatedDTO.getRegistrationNumber());

        Prescription prescription = new Prescription(medic.getName() + " " + medic.getLastName(), patient.getName() + " " + patient.getLastName(), prescriptionCreatedDTO.getMedicationPrescript(), prescriptionCreatedDTO.getRegistrationNumber());
        medic.addPrescription(prescription);
        patient.getClinicHistory().addPrescription(prescription);

        prescriptionService.savePrescription(prescription);
        medicService.saveMedic(medic);
        patientService.savePatient(patient);

        return  ResponseEntity.ok().build();
    }
}
