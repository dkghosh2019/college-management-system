package com.dkghosh.college.service;

import com.dkghosh.college.dto.DepartmentDTO;
import com.dkghosh.college.entity.Department;
import com.dkghosh.college.mapper.DepartmentMapper;
import com.dkghosh.college.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private DepartmentMapper departmentMapper;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private Department department;
    private DepartmentDTO dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        department = new Department();
        department.setId(1L);
        department.setName("CS");
        department.setDescription("Computer Science");

        dto = new DepartmentDTO();
        dto.setName("CS");
        dto.setDescription("Computer Science");
    }

    @Test
    void createDepartment_shouldReturnSavedDepartmentDTO() {

        when(departmentMapper.toEntity(dto)).thenReturn(department);
        when(departmentRepository.save(any())).thenReturn(department);
        when(departmentMapper.toDto(department)).thenReturn(dto);

        DepartmentDTO result = departmentService.createDepartment(dto);

        assertNotNull(result);
        assertEquals("CS", result.getName());

        verify(departmentRepository).save(any());
    }

    @Test
    void getAllDepartments_shouldReturnList() {

        when(departmentRepository.findAll()).thenReturn(List.of(department));
        when(departmentMapper.toDto(any())).thenReturn(dto);

        List<DepartmentDTO> result = departmentService.getAllDepartments();

        assertFalse(result.isEmpty());
    }

    @Test
    void getDepartments_withPagination_shouldReturnPage() {

        PageRequest pageRequest = PageRequest.of(0, 10);

        when(departmentRepository.findAll(pageRequest))
                .thenReturn(new PageImpl<>(List.of(department)));

        when(departmentMapper.toDto(any())).thenReturn(dto);

        Page<DepartmentDTO> result = departmentService.getDepartments(pageRequest);

        assertEquals(1, result.getTotalElements());
    }
}