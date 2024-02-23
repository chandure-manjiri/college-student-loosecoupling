package com.example.loosecoupling.controller;


import com.example.loosecoupling.dto.StudentCreationDto;
import com.example.loosecoupling.dto.StudentDto;
import com.example.loosecoupling.exception.InvalidPersonTypeException;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import com.example.loosecoupling.services.CollegeStudentsServices;
import com.example.loosecoupling.services.ParentServices;
import com.example.loosecoupling.services.ProfessorServices;
import com.example.loosecoupling.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/college")
public class StudentController {
    //automatically dependancy injection create object for the StudentSerives
    @Autowired
    private StudentServices studentServices;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    private CollegeStudentsServices collegeStudentsServices;

    private void setStudentServices(CollegeStudentsServices collegeStudentsServices){
        this.collegeStudentsServices = collegeStudentsServices;
    }

    // loose coupling handled
    @GetMapping("/students")
    public ResponseEntity<List> getStudents(){
        List studentDtoList = collegeStudentsServices.getAllList


        return ResponseEntity.ok().body(studentDtoList);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentCreationDto studentCreationDto){

        StudentDto studentDto = this.studentServices.createStudent(studentCreationDto);
        return ResponseEntity.ok().body(studentDto);

    }


}