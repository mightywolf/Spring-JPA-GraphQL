package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames = {"email"})
        }
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1  //define increments
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_seq"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;

    @Column(
            name = "age",
            nullable = false
    )
    private String age;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)  //cascaed will store both student and laptop data into database
    //@JoinColumn(name = "")
    private Laptop laptop;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Subject> subjectList;

    //@ManyToMany
    //private List<Division> divisions;

    private String fullName;

    public Student(String firstName, String lastName, String age, String email){
        this.firstName= firstName;
        this.lastName= lastName;
        this.age= age;
        this.email= email;
    }
}
