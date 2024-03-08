package com.example.microserviceredis.controller;

import com.example.microserviceredis.model.Student;
import com.example.microserviceredis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getListOfStudent(){

        return studentService.getAllStudents();
    }

    // to fetch Customer data using ID from Redis Database
    @GetMapping("/{id}")
    public Student getCustomer(@PathVariable int id){

        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){

        return studentService.addStudent(student);
    }


}
