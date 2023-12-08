package com.example.spring3.services.impl;

import com.example.spring3.dto.StudentDTO;
import com.example.spring3.model.Student;
import com.example.spring3.services.interfaces.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Override
    public Student addStudent(StudentDTO student) {
        return new Student(student);
    }
}
