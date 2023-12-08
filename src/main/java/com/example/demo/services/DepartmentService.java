package com.example.demo.services;

import com.example.demo.dtos.ApiResponse;
import com.example.demo.dtos.Data;
import com.example.demo.dtos.DepartmentDto;
import com.example.demo.exceptions.IncorrectArgumentException;
import com.example.demo.jpa.Department;
import com.example.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public ApiResponse addDepartment(Data<DepartmentDto> dto) {

        if (dto == null || dto.getData() == null) {
            throw new IncorrectArgumentException("dto is null");
        }
        if (dto.getData().getName() == null) {
            throw new IncorrectArgumentException("name is null");
        }

        Department department = new Department(dto.getData());

        return new ApiResponse("department", departmentRepository.save(department));

    }

}
