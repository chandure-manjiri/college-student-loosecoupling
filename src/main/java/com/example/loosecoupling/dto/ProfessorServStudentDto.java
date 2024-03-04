package com.example.loosecoupling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorServStudentDto{
    private Integer id;
    private String fullName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String department;
    private Integer year;
}