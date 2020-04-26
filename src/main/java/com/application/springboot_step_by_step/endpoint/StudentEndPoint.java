package com.application.springboot_step_by_step.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.springboot_step_by_step.model.Student;
import com.application.springboot_step_by_step.util.DateUtil;


@RestController
@RequestMapping("student")
public class StudentEndPoint {

    @RequestMapping(method = RequestMethod.GET, path = "/list" )  
    public ResponseEntity<?> listAll() {
        
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK); 
    }


}