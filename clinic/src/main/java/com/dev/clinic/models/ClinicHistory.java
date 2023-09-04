package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClinicHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String fullName, fullNameMedic, diagnostic, observation;
    private LocalDate creationDate;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @OneToMany(mappedBy = "clinicHistory", fetch = FetchType.EAGER)
    private Set<MedicalAppointments> medicalAppointments = new HashSet<>();
    @OneToMany(mappedBy = "clinicHistory", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions = new HashSet<>();

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

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Set<MedicalAppointments> getMedicalAppointments() {
        return medicalAppointments;
    }

    public void setMedicalAppointments(Set<MedicalAppointments> medicalAppointments) {
        this.medicalAppointments = medicalAppointments;
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

    public void addMedicalAppointments(MedicalAppointments medicalAppointment){
        medicalAppointment.setClinicHistory(this);
        medicalAppointments.add(medicalAppointment);
    }

    public void addPrescription(Prescription prescription){
        prescription.setClinicHistory(this);
        prescriptions.add(prescription);
    }
}
