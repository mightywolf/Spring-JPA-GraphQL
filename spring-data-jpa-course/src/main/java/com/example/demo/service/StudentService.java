package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentResponse;

public interface StudentService {

    public Student findStudentbyId(Long id);
}
