package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String lastName;
    private Integer age;
    private String registrationNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<MedicalSpecialties> medicalSpecialties = new HashSet<>();
    @OneToMany(mappedBy = "medic", fetch = FetchType.EAGER)
    private Set<MedicalAppointments>medicalAppointments = new HashSet<>();
    @OneToMany(mappedBy = "medic", fetch = FetchType.EAGER)
    private Set<Prescription> prescriptions = new HashSet<>();

    public Medic() {
    }

    public Medic(String name, String lastName, Integer age, String registrationNumber) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.registrationNumber = registrationNumber;
    }

    public long getId() {
        return id;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Set<MedicalAppointments> getMedicalAppointments() {
        return medicalAppointments;
    }

    public void setMedicalAppointments(Set<MedicalAppointments> medicalAppointments) {
        this.medicalAppointments = medicalAppointments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Set<MedicalSpecialties> getMedicalSpecialties() {
        return medicalSpecialties;
    }

    public void setMedicalSpecialties(Set<MedicalSpecialties> medicalSpecialties) {
        this.medicalSpecialties = medicalSpecialties;
    }

    public void addMedicalSpecialty(MedicalSpecialties medicalSpecialty) {
        this.medicalSpecialties.add(medicalSpecialty);
        medicalSpecialty.getMedics().add(this);
    }

    public void removeMedicalSpecialty(MedicalSpecialties medicalSpecialty) {
        this.medicalSpecialties.remove(medicalSpecialty);
        medicalSpecialty.getMedics().remove(this);
    }

    public void addMedicalAppointment(MedicalAppointments medicalAppointment){
       medicalAppointment.setMedic(this);
       medicalAppointments.add(medicalAppointment);
    }

    public void addPrescription(Prescription prescription){
        prescription.setMedic(this);
        prescriptions.add(prescription);
    }
}
