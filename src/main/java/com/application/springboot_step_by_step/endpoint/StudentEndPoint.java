package com.application.springboot_step_by_step.endpoint;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.springboot_step_by_step.model.Student;
import com.application.springboot_step_by_step.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;
import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndPoint {

    @Autowired
    private DateUtil dateUtil;

    @RequestMapping(method = RequestMethod.GET, path = "/list" )  
    public List<Student> listAll() {
        
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return asList(new Student("Deku"),new Student("Todoroki"));

    }

}