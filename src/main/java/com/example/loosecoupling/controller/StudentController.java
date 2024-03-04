package com.example.loosecoupling.controller;
import com.example.loosecoupling.dto.StudentDto;
import com.example.loosecoupling.services.CollegeServices;
import com.example.loosecoupling.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/colleges")
public class StudentController {
    //automatically dependancy injection create object for the StudentSerives
    @Autowired
    private StudentServices studentServices;


    private final CollegeServices collegeServices;

//    public StudentController(@Qualifier("parent") CollegeServices collegeStudentsServices) {
//        this.collegeServices = collegeStudentsServices;
//    }
    public StudentController(@Qualifier("student") CollegeServices collegeStudentsServices) {
        this.collegeServices = collegeStudentsServices;
    }

//    public StudentController(@Qualifier("professor") CollegeServices collegeStudentsServices) {
//        this.collegeServices = collegeStudentsServices;
//    }

    // loose coupling handled
    @GetMapping("/students")
    public ResponseEntity<List> getStudents(){
        List studentDtoList = collegeServices.getStudents();
        return ResponseEntity.ok().body(studentDtoList);
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){

        StudentDto studentDto1 = this.studentServices.createStudent(studentDto);
        return ResponseEntity.ok().body(studentDto1);

    }


}