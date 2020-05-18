package com.application.springboot_step_by_step.repository;

import com.application.springboot_step_by_step.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Long> {

    User findByUsername(String username);

}
