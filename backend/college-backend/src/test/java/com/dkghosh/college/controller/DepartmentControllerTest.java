package com.dkghosh.college.controller;

import com.dkghosh.college.dto.DepartmentDTO;
import com.dkghosh.college.service.DepartmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class DepartmentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DepartmentService departmentService;

    @Test
    void createDepartment_shouldReturn200() throws Exception {

        DepartmentDTO dto = new DepartmentDTO();
        dto.setName("CS");
        dto.setDescription("Computer Science");

        when(departmentService.createDepartment(any()))
                .thenReturn(dto);

        mockMvc.perform(post("/api/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("CS"));
    }
}