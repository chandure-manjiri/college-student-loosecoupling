package com.example.loosecoupling.services;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.StudentDtoForProc;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorServices implements CollegeStudentsServices<StudentDtoForProc>{


    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    public ProfessorServices(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<StudentDtoForProc> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();
        return studentMapper.converToStudentDtoForProcList(studentList);
    }
}