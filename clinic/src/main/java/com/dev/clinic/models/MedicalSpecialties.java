package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MedicalSpecialties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name, description;
    @ManyToMany(mappedBy = "medicalSpecialties")
    private Set<Medic> medics = new HashSet<>();

    public MedicalSpecialties() {
    }

    public MedicalSpecialties(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Medic> getMedics() {
        return medics;
    }

    public void setMedics(Set<Medic> medics) {
        this.medics = medics;
    }

    public void addMedic(Medic medic) {
        this.medics.add(medic);
        medic.getMedicalSpecialties().add(this);
    }

    public void removeMedic(Medic medic) {
        this.medics.remove(medic);
        medic.getMedicalSpecialties().remove(this);
    }

}
