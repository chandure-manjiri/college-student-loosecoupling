package com.example.loosecoupling.mapstruct;

import com.example.loosecoupling.Entity.Student;
import com.example.loosecoupling.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "year", source = "year")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "firstName", expression = "java(convertToFirstName(studentDto))")
    @Mapping(target = "lastName", expression = "java(convertToLastName(studentDto))")
    Student toEntity(StudentDto studentDto);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "year", source = "year")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    StudentDto toStudentDto(Student student);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "year", source = "year")
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    StudentServStudentDto toStudentServStudentDto(Student student);
    List<StudentServStudentDto> toStudentServStudentDtoList(List<Student> studentList);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "year", source = "year")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "age", source = "age")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    ProfessorServStudentDto toProfessorServStudentDto(Student student);
    List<ProfessorServStudentDto> toProfessorServStudentDtoList(List<Student> studentList);
    @Mapping(target = "department", source = "department")
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    ParentServStudentDto toParentServStudentDto(Student student);
    List<ParentServStudentDto> toParentServStudentDtoList(List<Student> studentList);

    @Named("toFirstName")
    default String convertToFirstName(StudentDto studentDto){
        if (studentDto.getFullName() == null){
            return null;
        }
        return studentDto.getFullName().substring(0, studentDto.getFullName().indexOf(" "));
    }
    @Named("toLastName")
    default String convertToLastName(StudentDto studentDTO){
        if (studentDTO.getFullName() == null){
            return null;
        }
        return studentDTO.getFullName().substring(studentDTO.getFullName().indexOf(" ") + 1);
    }

    @Named("toFullName")
    default String convertToFullName(String firstName, String lastName){
        String fullName = firstName;
        fullName += " ";
        fullName += lastName;
        return  fullName;
    }

}