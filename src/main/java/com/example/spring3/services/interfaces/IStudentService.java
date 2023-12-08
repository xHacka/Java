package com.example.spring3.services.interfaces;

import com.example.spring3.dto.StudentDTO;
import com.example.spring3.model.Student;

public interface IStudentService {
    public Student addStudent(StudentDTO student);

}
