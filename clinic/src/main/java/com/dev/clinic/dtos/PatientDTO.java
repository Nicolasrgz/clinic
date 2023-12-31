package com.dev.clinic.dtos;

import com.dev.clinic.models.Patient;

public class PatientDTO {

    private long id;
    private String name, profilePicture, lastName;
    private Integer dni;

    public PatientDTO() {
    }

    public PatientDTO(Patient patient) {
        this.name = patient.getName();
        this.lastName = patient.getLastName();
        this.dni = patient.getDni();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDni() {
        return dni;
    }

}
