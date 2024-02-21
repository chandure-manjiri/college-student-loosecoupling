package com.example.loosecoupling.mapstruct;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student converToEntity(StudentCreationDto studentCreationDto);

    StudentDto convertToStudentDto(Student student);

    StudentDtoForStudent convertToStudentDtoForStudent(Student student);
    List<StudentDtoForStudent> converToStudentDtoForStudentList(List<Student> studentList);
    StudentDtoForProc convertToStudentDtoForProc(Student student);
    List<StudentDtoForProc> converToStudentDtoForProcList(List<Student> studentList);
    StudentDtoForParent convertToStudentDtoForParent(Student student);
    List<StudentDtoForParent> converToStudentDtoForParentList(List<Student> studentList);
}
