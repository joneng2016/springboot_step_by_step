package com.application.springboot_step_by_step.endpoint;

import com.application.springboot_step_by_step.error.CustomErrorType;
import com.application.springboot_step_by_step.error.ResourceNotFoundException;
import com.application.springboot_step_by_step.model.Student;
import com.application.springboot_step_by_step.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentEndPoint {

    private final StudentRepository studentDAO;

    @Autowired
    public StudentEndPoint(StudentRepository studentDAO) {
        
        this.studentDAO = studentDAO; 

    }

    @GetMapping  
    public ResponseEntity<?> listAll() {
       
        return new ResponseEntity<>(this.studentDAO.findAll(), HttpStatus.OK); 
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
     
        verifyIfStudentExists(id);        
        Optional<Student> student = this.studentDAO.findById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name) {

        return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {

        return new ResponseEntity<>(studentDAO.save(student),HttpStatus.OK);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        verifyIfStudentExists(id);

        studentDAO.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) { 

        verifyIfStudentExists(student.getId());

        studentDAO.save(student);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    private void verifyIfStudentExists(Long id) {

        Optional<Student> student = this.studentDAO.findById(id);

        if (!student.isPresent())        
            throw new ResourceNotFoundException("Student not Found for ID: " + id);

    }

}