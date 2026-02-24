package com.dkghosh.college.service;

import com.dkghosh.college.entity.Department;
import com.dkghosh.college.repository.DepartmentRepository;
import com.dkghosh.college.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Page<Department> getDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
}

