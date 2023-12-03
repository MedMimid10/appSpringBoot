package com.example.appSpringBoot.controllers;

import com.example.appSpringBoot.model.Student;
import com.example.appSpringBoot.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/addRandomStudent")
    public Student generateRandomStudent() {
        // Generate random values for a student
        Random random = new Random();
        int id = random.nextInt(100); // Generate random id

        // Generate random name from this names-list
        String[] names = {"Ryan", "Nisrin", "Charlie", "David", "Emma"};
        String name = names[random.nextInt(names.length)];

        int age = random.nextInt(12) + 18; // Generate Random age

        // Generate random email from this emails-list
        String[] emails = {"example1@example.com", "example2@example.com", "example3@example.com", "exampleX@example.com", "exampleY@example.com"};
        String email = emails[random.nextInt(emails.length)];

        // Create a student object
        Student student = new Student(id, name, age, email);

        // Save the random student created
        return studentService.addStudent(student);
    }
}

