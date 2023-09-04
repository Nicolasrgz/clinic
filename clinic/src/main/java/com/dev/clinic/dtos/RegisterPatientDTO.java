package com.dev.clinic.dtos;

import com.dev.clinic.models.Patient;

public class RegisterPatientDTO {
    private long id;
    private String name, lastName, email, password;
    private Integer dni, age;

    public RegisterPatientDTO() {
    }

    public RegisterPatientDTO(Patient patient) {
        this.name = patient.getName();
        this.lastName = patient.getLastName();
        this.dni = patient.getDni();
        this.age = patient.getAge();
        this.email = patient.getEmail();
        this.password = patient.getPassword();
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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getDni() {
        return dni;
    }

    public Integer getAge() {
        return age;
    }
}
