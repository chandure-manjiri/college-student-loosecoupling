package com.example.loosecoupling.services;
import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.ProfessorServStudentDto;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("professor")
public class ProfessorService implements CollegeServices<ProfessorServStudentDto>{


    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;
    @Autowired
    public ProfessorService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
    @Override
    public List<ProfessorServStudentDto> getStudents() {
        List<Student> studentList = this.studentRepository.findAll();
        return studentMapper.toProfessorServStudentDtoList(studentList);
    }
}