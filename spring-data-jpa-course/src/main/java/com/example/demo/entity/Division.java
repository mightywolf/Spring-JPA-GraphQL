package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Division")
@Table(name = "division")
public class Division {
    @Id
    private String dId;
    private String dName;

    //@ManyToMany(mappedBy = "divisions",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //public List<Student> students= new ArrayList<>();

}
