package com.dkghosh.college;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CollegeManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemBackendApplication.class, args);
	}

}
