package com.dev.clinic.controllers;

import com.dev.clinic.dtos.ClinicHistoryDTO;
import com.dev.clinic.models.ClinicHistory;
import com.dev.clinic.models.Patient;
import com.dev.clinic.repositories.ClinicHistoryRepository;
import com.dev.clinic.repositories.PatientRepository;
import com.dev.clinic.services.service.ClinicHistoryService;
import com.dev.clinic.services.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClinicHistoryController {

    @Autowired
    private ClinicHistoryService clinicHistoryService;
    @Autowired
    private ClinicHistoryRepository clinicHistoryRepository;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("histories")
    public List<ClinicHistoryDTO>getClinicHistories(){
        return clinicHistoryService.getClinicHistories();
    }

    @PostMapping("/history/clinic")
    public ResponseEntity<Object> creationHistoryClinic(@RequestBody ClinicHistoryDTO clinicHistoryDTO){

        Patient patient = patientService.findByDni(clinicHistoryDTO.getDni());

        if (patient == null) {
            return new ResponseEntity<>("No patient was found with the ID provided", HttpStatus.NOT_FOUND);
        }
        if (patient.getClinicHistory() != null) {
            return new ResponseEntity<>("The patient already has an associated clinical history", HttpStatus.CONFLICT);
        }
        if (clinicHistoryDTO.getFullName().isBlank()){
            return new ResponseEntity<>("The full name field is incomplete", HttpStatus.BAD_REQUEST);
        }
        if (clinicHistoryDTO.getFullNameMedic().isBlank()){
            return new ResponseEntity<>("The full name medic field is incomplete", HttpStatus.BAD_REQUEST);
        }
        if (clinicHistoryDTO.getCreationDate() == null){
            return new ResponseEntity<>("The date field is incomplete", HttpStatus.BAD_REQUEST);
        }
        if (clinicHistoryDTO.getDiagnostic().isBlank()){
            return new ResponseEntity<>("The diagnostic field is incomplete", HttpStatus.BAD_REQUEST);
        }
        if (clinicHistoryDTO.getObservation().isBlank()){
            return new ResponseEntity<>("The observation field is incomplete", HttpStatus.BAD_REQUEST);
        }

        ClinicHistory clinicHistory = new ClinicHistory(clinicHistoryDTO.getFullName(), clinicHistoryDTO.getCreationDate(), clinicHistoryDTO.getFullNameMedic(), clinicHistoryDTO.getDiagnostic(), clinicHistoryDTO.getObservation(), patient.getDni());
        patient.addClinicHistory(clinicHistory);
        clinicHistoryService.saveClinicHistory(clinicHistory);
        patientService.savePatient(patient);

        return ResponseEntity.ok().build();
    }

}
