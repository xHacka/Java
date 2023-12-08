package com.example.demo.controllers;

import com.example.demo.dtos.ApiResponse;
import com.example.demo.dtos.Data;
import com.example.demo.dtos.DepartmentDto;
import com.example.demo.jpa.Department;
import com.example.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public ApiResponse addDepartment(@RequestBody Data<DepartmentDto> dto) {
        return this.departmentService.addDepartment(dto);
    }

}