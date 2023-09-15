package com.dev.clinic.dtos;

import com.dev.clinic.models.Medic;
import com.dev.clinic.models.Patient;
import com.dev.clinic.models.Prescription;

public class PrescriptionCreatedDTO {

    private long id;
    private String fullNameMedic, fullNamePatient, medicationPrescript,registrationNumber;

    private Integer dni;

    public PrescriptionCreatedDTO() {
    }

    public PrescriptionCreatedDTO(Prescription prescription, Medic medic, Patient patient) {
        this.fullNameMedic = prescription.getFullNameMedic();
        this.fullNamePatient = prescription.getFullNamePatient();
        this.medicationPrescript = prescription.getMedicationPrescript();
        this.registrationNumber = medic.getRegistrationNumber();
        this.dni = patient.getDni();
    }

    public long getId() {
        return id;
    }

    public String getFullNameMedic() {
        return fullNameMedic;
    }

    public String getFullNamePatient() {
        return fullNamePatient;
    }

    public String getMedicationPrescript() {
        return medicationPrescript;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Integer getDni() {
        return dni;
    }
}
