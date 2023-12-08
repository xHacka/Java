package com.example.spring3.model;

import com.example.spring3.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private Long id;
    private String firstName;
    private String lastName;

    public Student(StudentDTO dto) {
        if (dto != null) {
            this.firstName = dto.getFirstName();
            this.lastName = dto.getLastName();
        }
    }
}
