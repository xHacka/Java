package com.example.demo.repositories;

import com.example.demo.jpa.Department;
import com.example.demo.jpa.RecordState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findDepartmentsByRecordState(RecordState recordState);

    Optional<Department> findByIdAndRecordState(Long id, RecordState recordState);

}