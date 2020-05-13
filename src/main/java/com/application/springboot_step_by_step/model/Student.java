package com.application.springboot_step_by_step.model;

import com.application.springboot_step_by_step.model.Student;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
public class Student extends AbstractEntity{

    @NotEmpty
    private String name;

    @Email
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    
}