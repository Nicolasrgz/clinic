package com.dev.clinic.dtos;

import com.dev.clinic.models.MedicalSpecialties;

import java.util.Set;

public class MedicalSpecialtiesDTO {
    private long id;
    private String name;
    private String description;

    public MedicalSpecialtiesDTO() {
    }
    public MedicalSpecialtiesDTO(MedicalSpecialties medicalSpecialties) {
        this.name = medicalSpecialties.getName();
        this.description = medicalSpecialties.getDescription();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
