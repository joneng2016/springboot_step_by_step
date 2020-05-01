package com.application.springboot_step_by_step.endpoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.springboot_step_by_step.error.CustomErrorType;
import com.application.springboot_step_by_step.model.Student;



@RestController
@RequestMapping("students")
public class StudentEndPoint {

    @RequestMapping(method = RequestMethod.GET)  
    public ResponseEntity<?> listAll() {
        
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK); 
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
         
        Student student = new Student();

        student.setId(id);

        int index = Student.studentList.indexOf(student);
        
        
        if (index == -1) 
            return new ResponseEntity<>(new CustomErrorType("Student not Found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }

}