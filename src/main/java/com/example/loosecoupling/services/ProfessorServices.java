package com.example.loosecoupling.services;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.StudentDtoForProc;
import com.example.loosecoupling.dto.StudentDtoForStudent;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorServices implements CollegeStudentsServices<StudentDtoForProc>{

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<StudentDtoForProc> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();
        return studentMapper.converToStudentDtoForProcList(studentList);
    }
}
