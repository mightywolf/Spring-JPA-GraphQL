package com.example.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.enus.SubjectNameFilter;
import com.example.demo.model.StudentResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<Student> {

    public String getFullName(Student student){
        return student.getFirstName()+""+student.getLastName();
    }

    public List<Subject> getSubjectList(Student student, SubjectNameFilter nameFilter){
        List<Subject> subjectList= new ArrayList<>();
        if(student.getSubjectList() !=null){
            for(Subject subject: student.getSubjectList()){
                if(nameFilter.name().equals(subject.getSubjectName())){
                    subjectList.add(subject);
                }
            }
        }
        return subjectList;
    }
}
