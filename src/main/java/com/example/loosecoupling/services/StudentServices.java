package com.example.loosecoupling.services;

import com.example.loosecoupling.Entity.Student;

import com.example.loosecoupling.dto.StudentDto;
import com.example.loosecoupling.dto.StudentServStudentDto;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
@Service("student")
public class StudentServices implements CollegeServices<StudentServStudentDto>{


    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServices(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<StudentServStudentDto> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();

        return this.studentMapper.converToStudentDtoForStudentList(studentList);
    }

    public StudentDto createStudent(StudentDto studentDto){
        // System.out.println(studentCreationDto.getPhone_number());
        Student student = this.studentMapper.converToEntity(studentDto);
        //  System.out.println(student.getPhone_number());
        this.studentRepository.save(student);
        return this.studentMapper.convertToStudentDto(student);
    }
}