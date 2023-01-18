package com.example.demo.model;

import com.example.demo.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String email;

    private String fullName;

    public StudentResponse(Student student) {
        this.firstName=student.getFirstName();
        this.lastName=student.getLastName();
        this.email=student.getEmail();
        this.age=student.getAge();
    }
}
