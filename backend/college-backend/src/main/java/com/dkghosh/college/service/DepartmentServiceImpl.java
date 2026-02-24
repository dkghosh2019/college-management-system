package com.dkghosh.college.service;

import com.dkghosh.college.dto.DepartmentDTO;
import com.dkghosh.college.entity.Department;
import com.dkghosh.college.exception.ResourceNotFoundException;
import com.dkghosh.college.mapper.DepartmentMapper;
import com.dkghosh.college.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO dto) {

        Department department = departmentMapper.toEntity(dto);

        Department saved = departmentRepository.save(department);

        return departmentMapper.toDto(saved);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id: " + id));

        return departmentMapper.toDto(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(departmentMapper::toDto)
                .toList();
    }

    @Override
    public Page<DepartmentDTO> getDepartments(Pageable pageable) {

        return departmentRepository.findAll(pageable)
                .map(departmentMapper::toDto);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {

        Department existing = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department not found with id: " + id));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());

        Department updated = departmentRepository.save(existing);

        return departmentMapper.toDto(updated);
    }

    @Override
    public void deleteDepartment(Long id) {

        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }

        departmentRepository.deleteById(id);
    }
}