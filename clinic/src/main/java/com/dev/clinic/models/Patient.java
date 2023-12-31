package com.dev.clinic.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name, lastName, email, password;
    private Integer dni, age;

    @OneToOne(mappedBy = "patient")
    private ClinicHistory clinicHistory;

    public Patient() {
    }

    public Patient(String name, String lastName, Integer dni, Integer age, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.age = age;
        this.email= email;
        this.password = password;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClinicHistory getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(ClinicHistory clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void addClinicHistory(ClinicHistory clinicHistory){
        this.clinicHistory = clinicHistory;
        clinicHistory.setPatient(this);
    }
}
