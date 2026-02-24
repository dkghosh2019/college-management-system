package com.dkghosh.college.mapper;

import com.dkghosh.college.dto.DepartmentDTO;
import com.dkghosh.college.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDTO toDto(Department department);

    Department toEntity(DepartmentDTO dto);
}