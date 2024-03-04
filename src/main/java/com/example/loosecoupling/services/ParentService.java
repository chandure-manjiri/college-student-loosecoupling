package com.example.loosecoupling.services;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.ParentServStudentDto;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("parent")
public class ParentService implements CollegeServices<ParentServStudentDto>{

    private final StudentMapper studentMapper;

    final private StudentRepository studentRepository;
    @Autowired
    public ParentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<ParentServStudentDto> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();
        return studentMapper.convertToStudentDtoForParentList(studentList);
    }
}