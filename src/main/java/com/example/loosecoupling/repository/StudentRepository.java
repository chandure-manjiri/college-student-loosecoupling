package com.example.loosecoupling.repository;

import com.example.loosecoupling.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
