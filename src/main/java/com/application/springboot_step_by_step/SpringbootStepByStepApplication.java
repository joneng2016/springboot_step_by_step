package com.application.springboot_step_by_step;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.application.springboot_step_by_step.endpoint")
public class SpringbootStepByStepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStepByStepApplication.class, args);
	}

}
