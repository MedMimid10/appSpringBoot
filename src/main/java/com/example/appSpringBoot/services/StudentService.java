package com.example.appSpringBoot.services;

import com.example.appSpringBoot.model.Student;
import com.example.appSpringBoot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Get the students list
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //Add the student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
