package com.dev.clinic.dtos;

import com.dev.clinic.models.Medic;
import com.dev.clinic.models.MedicalSpecialties;

import java.util.Set;
import java.util.stream.Collectors;

public class MedicDTO {

    private long id;
    private String name;
    private String lastName;
    private Integer age;
    private String registrationNumber;
    private Set<MedicalSpecialtiesDTO> medicalSpecialties;

    public MedicDTO() {
    }

    public MedicDTO(Medic medic) {
        this.name = medic.getName();
        this.lastName = medic.getLastName();
        this.age = medic.getAge();
        this.registrationNumber = medic.getRegistrationNumber();
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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Set<MedicalSpecialtiesDTO> getMedicalSpecialties() {
        return medicalSpecialties;
    }
}
