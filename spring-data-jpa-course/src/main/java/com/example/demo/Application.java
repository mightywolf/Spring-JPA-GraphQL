package com.example.demo;

import com.example.demo.entity.Division;
import com.example.demo.entity.Laptop;
import com.example.demo.entity.Student;
import com.example.demo.entity.Subject;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Laptop laptop;

            Student kiran = new Student("kiran", "Chavan", "34", "kiranchavan770@gmail.com");
            laptop = new Laptop(123L, "MJUK", "APPLE", kiran);

            kiran.setLaptop(laptop);
            Laptop laptop1;
            Student amey = new Student("amey", "Chavan", "27", "ameychavan770@gmail.com");
            laptop1 = new Laptop(12L, "MJUKLO", "DELL", amey);
            amey.setLaptop(laptop1);

            Student arjun = new Student("arjun", "raut", "26", "arjunraut880@gmail.com");
            arjun.setLaptop(laptop1);

            //ONE TO MANY
            Subject subject = new Subject(1L,"JAVA",kiran);

            Subject subject1 = new Subject(2L,"PYTHON",kiran);

            Subject subject2 = new Subject(3L,"RUBY",kiran);

            List<Subject> kiranSubjectList= new ArrayList<>();
            kiranSubjectList.add(subject);
            kiranSubjectList.add(subject1);
            kiranSubjectList.add(subject2);

            Subject subject4 = new Subject(4L,"JAVA",amey);

            Subject subject5 = new Subject(5L,"PYTHON",amey);

            List<Subject> ameySubjectList= new ArrayList<>();
            ameySubjectList.add(subject4);
            ameySubjectList.add(subject5);

            List<Subject> arjunSubjectList= new ArrayList<>();
            arjunSubjectList.add(subject4);
            arjunSubjectList.add(subject5);

            kiran.setSubjectList(kiranSubjectList);
            amey.setSubjectList(ameySubjectList);
            arjun.setSubjectList(arjunSubjectList);

            List<Student> students = new ArrayList<>();
            students.add(kiran);
            students.add(amey);
            studentRepository.saveAll(students);

            /*List<Student> students1= new ArrayList<>();
            students1.add(kiran);
            students1.add(amey);

            List<Student> students2= new ArrayList<>();
            students2.add(arjun);
            students2.add(amey);

            List<Student> students3= new ArrayList<>();
            students3.add(arjun);
            students3.add(kiran);
            students3.add(amey);

            Division division1= new Division("D101","Electronins");
            division1.setStudents(students1);

            Division division2= new Division("D102","C#");
            division2.setStudents(students3);

            Division division3= new Division("D103","Maths");
            division3.setStudents(students2);

            Division division4= new Division("D104","Embedded System");
            division4.setStudents(students1);*/

            //MANY TO MANY
            /*Student kiran = new Student("kiran", "Chavan", "34", "kiranchavan770@gmail.com");
            Student amey = new Student("amey", "Chavan", "27", "ameychavan770@gmail.com");
            Student arjun = new Student("arjun", "raut", "26", "arjunraut880@gmail.com");

            List<Student> students1= new ArrayList<>();
            students1.add(kiran);
            students1.add(amey);

            List<Student> students2= new ArrayList<>();
            students2.add(arjun);
            students2.add(amey);

            List<Student> students3= new ArrayList<>();
            students3.add(arjun);
            students3.add(kiran);
            students3.add(amey);

            Division division1= new Division("D101","Electronins");
            division1.setStudents(students1);

            Division division2= new Division("D102","C#");
            division2.setStudents(students3);

            Division division3= new Division("D103","Maths");
            division3.setStudents(students2);

            Division division4= new Division("D104","Embedded System");
            division4.setStudents(students1);

            studentRepository.saveAll(students);*/

            //List<Division> kiranDivisions= new ArrayList<>();
            //kiranDivisions.add(division1);
            //kiranDivisions.add(division3);
            //kiran.getDivisions(kiranDivisions);

        };
    }
}
