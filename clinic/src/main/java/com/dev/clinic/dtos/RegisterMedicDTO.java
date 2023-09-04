package com.dev.clinic.dtos;

import com.dev.clinic.models.Medic;

public class RegisterMedicDTO {
    private long id;
    private String name,lastName, email, password;
    private Integer age;

    public RegisterMedicDTO() {
    }

    public RegisterMedicDTO(Medic medic) {
        this.name = medic.getName();
        this.lastName = medic.getLastName();
        this.age = medic.getAge();
        this.email = medic.getEmail();
        this.password = medic.getPassword();
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

    public String getPassword() {
        return password;
    }
}
