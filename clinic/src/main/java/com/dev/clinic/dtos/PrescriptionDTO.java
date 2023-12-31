package com.dev.clinic.dtos;

import com.dev.clinic.models.Prescription;

public class PrescriptionDTO {

    private long id;
    private String fullNameMedic, fullNamePatient, medicationPrescript,registrationNumber;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(Prescription prescription) {
        this.fullNameMedic = prescription.getFullNameMedic();
        this.fullNamePatient = prescription.getFullNamePatient();
        this.medicationPrescript = prescription.getMedicationPrescript();
        this.registrationNumber = prescription.getRegistrationNumber();
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
}
