package com.application.springboot_step_by_step.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.springboot_step_by_step.model.Student;

import java.util.List;
import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndPoint {

    @RequestMapping(method = RequestMethod.GET, path = "/list" )  
    public List<Student> listAll() {
        
        return asList(new Student("Deku"),new Student("Todoroki"));

    }

}