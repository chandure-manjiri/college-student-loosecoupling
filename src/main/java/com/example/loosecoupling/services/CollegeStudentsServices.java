package com.example.loosecoupling.services;

import java.util.List;

public interface CollegeStudentsServices <T>{
    public List<T> getStudents();
}