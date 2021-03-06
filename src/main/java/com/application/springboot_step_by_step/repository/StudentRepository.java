package com.application.springboot_step_by_step.repository;

import java.util.List;

import com.application.springboot_step_by_step.model.Student;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findByName(String name);

    List<Student> findByNameIgnoreCaseContaining(String name);

}