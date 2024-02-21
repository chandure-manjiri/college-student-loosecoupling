package com.example.loosecoupling.services;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.StudentCreationDto;
import com.example.loosecoupling.dto.StudentDto;
import com.example.loosecoupling.dto.StudentDtoForStudent;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;
@Service
public class StudentServices implements CollegeStudentsServices<StudentDtoForStudent>{


    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;


    public StudentServices(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<StudentDtoForStudent> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();

        return this.studentMapper.converToStudentDtoForStudentList(studentList);
    }

    public StudentDto createStudent(StudentCreationDto studentCreationDto){
       // System.out.println(studentCreationDto.getPhone_number());
        Student student = this.studentMapper.converToEntity(studentCreationDto);
      //  System.out.println(student.getPhone_number());
        this.studentRepository.save(student);
        return this.studentMapper.convertToStudentDto(student);
    }
}
