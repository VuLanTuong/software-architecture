package com.example.microserviceredis.service;

import com.example.microserviceredis.model.Student;
import com.example.microserviceredis.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){

        List<Student> allStudent = new ArrayList<>();
        studentRepository.findAll().forEach(allStudent::add);
        return allStudent;
    }

    // fetch operation to get customer using an ID
    public Student getStudentById(int id){

        Optional<Student> optionalCustomer
                = studentRepository.findById(String.valueOf(id));
        return optionalCustomer.orElse(null);
    }


    public Student addStudent(Student student){

        return studentRepository.save(student);
    }

}
