package com.dkghosh.college.controller;

import com.dkghosh.college.dto.DepartmentDTO;
import com.dkghosh.college.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(
            @Valid @RequestBody DepartmentDTO dto) {

        return ResponseEntity.ok(
                departmentService.createDepartment(dto)
        );
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAll() {
        return ResponseEntity.ok(
                departmentService.getAllDepartments()
        );
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DepartmentDTO>> getPagedDepartments(
            Pageable pageable) {

        return ResponseEntity.ok(
                departmentService.getDepartments(pageable)
        );
    }
}