package com.dkghosh.college.service;

import com.dkghosh.college.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Page<Department> getDepartments(Pageable pageable);
}