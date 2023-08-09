package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ClinicHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String fullName;
    private LocalDate creationDate;
    private String fullNameMedic;
    private String diagnostic;
    private String observation;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public ClinicHistory() {
    }

    public ClinicHistory(String fullName, LocalDate creationDate, String fullNameMedic, String diagnostic, String observation) {
        this.fullName = fullName;
        this.creationDate = creationDate;
        this.fullNameMedic = fullNameMedic;
        this.diagnostic = diagnostic;
        this.observation = observation;
    }

    public long getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getFullNameMedic() {
        return fullNameMedic;
    }

    public void setFullNameMedic(String fullNameMedic) {
        this.fullNameMedic = fullNameMedic;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
