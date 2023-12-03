package com.example.appSpringBoot.repositories;

import com.example.appSpringBoot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Save a student
    Student save(Student student);

    // Get all students
    List<Student> findAll();



}
