package com.dkghosh.college.controller;

import com.dkghosh.college.entity.Department;
import com.dkghosh.college.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @Valid @RequestBody Department department) {

        return ResponseEntity.ok(
                departmentService.createDepartment(department)
        );
    }

    @GetMapping
    public List<Department> getAll() {
        return departmentService.getAllDepartments();
    }
}