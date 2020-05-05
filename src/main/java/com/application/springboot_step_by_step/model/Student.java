package com.application.springboot_step_by_step.model;

import com.application.springboot_step_by_step.model.Student;

import javax.persistence.Entity;


@Entity
public class Student extends AbstractEntity{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}