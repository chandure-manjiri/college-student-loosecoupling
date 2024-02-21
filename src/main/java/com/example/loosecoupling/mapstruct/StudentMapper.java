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
    @Mapping(target = "phone_number", source = "phone_number")
    @Mapping(target = "firstName", expression = "java(convertToFirstName(studentCreationDto))")
    @Mapping(target = "lastName", expression = "java(convertToLastName(studentCreationDto))")
    Student converToEntity(StudentCreationDto studentCreationDto);
    @Mapping(target = "year", source = "year")
    @Mapping(target = "department", source = "department")
    @Mapping(target = "phone_number", source = "phone_number")
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    StudentDto convertToStudentDto(Student student);


    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    StudentDtoForStudent convertToStudentDtoForStudent(Student student);
    List<StudentDtoForStudent> converToStudentDtoForStudentList(List<Student> studentList);
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    StudentDtoForProc convertToStudentDtoForProc(Student student);
    List<StudentDtoForProc> converToStudentDtoForProcList(List<Student> studentList);
    @Mapping(target = "fullName", expression = "java(convertToFullName(student.getFirstName(), student.getLastName()))")
    StudentDtoForParent convertToStudentDtoForParent(Student student);
    List<StudentDtoForParent> converToStudentDtoForParentList(List<Student> studentList);

    @Named("toFirstName")
    default String convertToFirstName(StudentCreationDto studentCreationDto){
        if (studentCreationDto.getFullName() == null){
            return null;
        }
        return studentCreationDto.getFullName().substring(0, studentCreationDto.getFullName().indexOf(" "));
    }
    @Named("toLastName")
    default String convertToLastName(StudentCreationDto studentCreationDTO){
        if (studentCreationDTO.getFullName() == null){
            return null;
        }
        return studentCreationDTO.getFullName().substring(studentCreationDTO.getFullName().indexOf(" ") + 1);
    }

    @Named("toFullName")
    default String convertToFullName(String firstName, String lastName){
        String fullName = firstName;
        fullName += " ";
        fullName += lastName;
        return  fullName;
    }

}
