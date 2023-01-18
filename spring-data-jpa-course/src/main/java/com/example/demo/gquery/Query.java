package com.example.demo.gquery;

import com.example.demo.entity.Student;
import com.example.demo.model.SampleRequest;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String fullName(SampleRequest req) {
        return req.getFirstName()+" "+req.getLastName();
    }

    public Student getStudent(Long id){
        return studentService.findStudentbyId(id);

    }
}