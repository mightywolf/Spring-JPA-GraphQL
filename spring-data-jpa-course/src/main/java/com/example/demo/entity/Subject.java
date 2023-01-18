package com.example.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Subject")
@Table(name = "subject")
public class Subject {
    @Id
    private long id;

    private String subjectName;

    @ManyToOne
    private Student student;

    public Subject(long id,String subjectName){
        this.id=id;
        this.subjectName= subjectName;
    }
}
