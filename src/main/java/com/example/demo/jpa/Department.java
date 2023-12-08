package com.example.demo.jpa;

import com.example.demo.dtos.DepartmentDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DEPARTMENTS")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Department extends BaseEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "departmentIdSeq", sequenceName = "DEPARTMENT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "departmentIdSeq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NAME", nullable = false, insertable = true, updatable = true)
    private String name;

    public Department(DepartmentDto dto) {
        if (dto != null) {
            this.name = dto.getName();
        }
    }

}