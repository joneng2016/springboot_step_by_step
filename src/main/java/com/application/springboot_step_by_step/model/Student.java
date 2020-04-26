package com.application.springboot_step_by_step.model;

import com.application.springboot_step_by_step.model.Student;

import java.util.List;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Student {

    private int id;
    private String name;
    public static List<Student> studentList;

    static {
        studentRepository();
    }

    public Student(int id, String name) {

        this.name = name;
        this.id = id;

    }


    public Student(String name) {

        this.name = name;
    
    }

    public Student() {
        
    }

    public static void studentRepository() {
        studentList = new ArrayList<>(asList(new Student("Deku"),new Student("Todoroki")));
    }
    
    public int getId() {

        return this.id;
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}