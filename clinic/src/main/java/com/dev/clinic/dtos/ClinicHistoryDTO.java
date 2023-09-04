package com.dev.clinic.dtos;

import com.dev.clinic.models.ClinicHistory;

import java.time.LocalDate;

public class ClinicHistoryDTO {
    private long id;
    private String fullName, fullNameMedic, diagnostic, observation;
    private LocalDate creationDate;

    public ClinicHistoryDTO() {
    }
    public ClinicHistoryDTO(ClinicHistory clinicHistory) {
        this.fullName = clinicHistory.getFullName();
        this.creationDate = clinicHistory.getCreationDate();
        this.fullNameMedic = clinicHistory.getFullNameMedic();
        this.diagnostic = clinicHistory.getDiagnostic();
        this.observation = clinicHistory.getObservation();
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getFullNameMedic() {
        return fullNameMedic;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getObservation() {
        return observation;
    }
}
