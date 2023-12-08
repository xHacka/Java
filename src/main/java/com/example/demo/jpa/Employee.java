package com.example.demo.jpa;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "employeeIdSeq", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "employeeIdSeq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "SALARY")
    private Integer salary;

    @Column(name = "FULL_NAME")
    private String fullName;

    @ManyToOne
    private Department department;

}