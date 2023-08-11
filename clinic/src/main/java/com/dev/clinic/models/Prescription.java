package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String fullNameMedic;
    private String fullNamePatient;
    private String medicationPrescript;
    private String registrationNumber;
    private String firma;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicHistory")
    private ClinicHistory clinicHistory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medic")
    private Medic medic;

    public Prescription() {
    }

    public Prescription(String fullNameMedic, String fullNamePatient, String medicationPrescript, String registrationNumber, String firma) {
        this.fullNameMedic = fullNameMedic;
        this.fullNamePatient = fullNamePatient;
        this.medicationPrescript = medicationPrescript;
        this.registrationNumber = registrationNumber;
        this.firma = firma;
    }

    public long getId() {
        return id;
    }

    public ClinicHistory getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(ClinicHistory clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public String getFullNameMedic() {
        return fullNameMedic;
    }

    public void setFullNameMedic(String fullNameMedic) {
        this.fullNameMedic = fullNameMedic;
    }

    public String getFullNamePatient() {
        return fullNamePatient;
    }

    public void setFullNamePatient(String fullNamePatient) {
        this.fullNamePatient = fullNamePatient;
    }

    public String getMedicationPrescript() {
        return medicationPrescript;
    }

    public void setMedicationPrescript(String medicationPrescript) {
        this.medicationPrescript = medicationPrescript;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
