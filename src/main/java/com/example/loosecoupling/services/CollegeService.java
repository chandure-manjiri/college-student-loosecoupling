package com.example.loosecoupling.services;


import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.StudentDto;
import com.example.loosecoupling.mapstruct.StudentMapper;
import com.example.loosecoupling.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("college")
public class CollegeService{

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    @Autowired
    public CollegeService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDto createStudent(StudentDto studentDto){
        Student student = this.studentMapper.toEntity(studentDto);
        this.studentRepository.save(student);
        return this.studentMapper.toStudentDto(student);
    }
}
