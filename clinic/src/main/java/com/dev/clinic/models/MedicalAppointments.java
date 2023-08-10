package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalAppointments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private LocalDate date;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medic")
    private Medic medic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicHistory")
    private ClinicHistory clinicHistory;

    public MedicalAppointments() {
    }

    public MedicalAppointments(LocalDate date, String description) {
        this.date = date;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public ClinicHistory getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(ClinicHistory clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
