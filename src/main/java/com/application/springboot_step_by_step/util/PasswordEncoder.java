package com.application.springboot_step_by_step.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.print(passwordEncoder.encode("senha"));

    }
}