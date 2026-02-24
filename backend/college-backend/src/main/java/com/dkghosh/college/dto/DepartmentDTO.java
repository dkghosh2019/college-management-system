package com.dkghosh.college.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DepartmentDTO {

    private Long id;

    @NotBlank(message = "Department name cannot be empty")
    private String name;

    private String description;
}