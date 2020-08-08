package com.example.student.persistent.repository;

import com.example.student.persistent.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
