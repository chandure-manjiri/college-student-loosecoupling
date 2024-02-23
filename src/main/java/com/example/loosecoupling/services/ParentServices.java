package com.example.loosecoupling.services;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.StudentDtoForParent;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("parent")
public class ParentServices implements CollegeStudentsServices<StudentDtoForParent>{

    private final StudentMapper studentMapper;

    final private StudentRepository studentRepository;
    @Autowired
    public ParentServices(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<StudentDtoForParent> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();
        return studentMapper.converToStudentDtoForParentList(studentList);
    }
}