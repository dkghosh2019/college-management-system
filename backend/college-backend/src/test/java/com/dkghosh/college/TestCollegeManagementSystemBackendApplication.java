package com.dkghosh.college;

import org.springframework.boot.SpringApplication;

public class TestCollegeManagementSystemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(CollegeManagementSystemBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
