package com.dev.clinic.dtos;

import com.dev.clinic.models.Patient;

public class PatientDTO {

    private long id;
    private String name;
    private String lastName;
    private Integer dni;
    private String profilePicture;

    public PatientDTO() {
    }

    public PatientDTO(Patient patient) {
        this.name = patient.getName();
        this.lastName = patient.getLastName();
        this.dni = patient.getDni();
        this.profilePicture = patient.getProfilePicture();
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

    public String getProfilePicture() {
        return profilePicture;
    }
}
