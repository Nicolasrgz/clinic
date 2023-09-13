package com.dev.clinic.dtos;

import com.dev.clinic.models.Medic;

import java.util.Set;
import java.util.stream.Collectors;

public class RegisterMedicDTO {
    private long id;
    private String name,lastName, email, password;
    private Integer age;
    private Set<MedicalSpecialtiesDTO> medicalSpecialties;

    public RegisterMedicDTO() {
    }

    public RegisterMedicDTO(Medic medic) {
        this.name = medic.getName();
        this.lastName = medic.getLastName();
        this.age = medic.getAge();
        this.email = medic.getEmail();
        this.password = medic.getPassword();
        this.medicalSpecialties = medic.getMedicalSpecialties()
                .stream()
                .map(MedicalSpecialtiesDTO::new)
                .collect(Collectors.toSet());
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
}
