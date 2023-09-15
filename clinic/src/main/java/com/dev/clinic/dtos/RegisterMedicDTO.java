package com.dev.clinic.dtos;

import com.dev.clinic.models.Medic;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RegisterMedicDTO {
    private long id;
    private String name,lastName, email, password, nameSpecialty, description;
    private Integer age;
    private Set<MedicalSpecialtiesDTO> medicalSpecialties;

    public RegisterMedicDTO() {
    }

    public RegisterMedicDTO(Medic medic, String nameSpecialty, String description) {
        this.name = medic.getName();
        this.lastName = medic.getLastName();
        this.age = medic.getAge();
        this.email = medic.getEmail();
        this.password = medic.getPassword();
        this.nameSpecialty = nameSpecialty;
        this.description = description;
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
    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
    public Set<MedicalSpecialtiesDTO> getMedicalSpecialties() {
        return medicalSpecialties;
    }
    public String getPassword() {
        return password;
    }

    public String getNameSpecialty() {
        return nameSpecialty;
    }

    public String getDescription() {
        return description;
    }
}
