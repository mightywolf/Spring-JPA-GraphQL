package com.example.demo.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Laptop")
@Table(name="laptops")
public class Laptop {
    @Id
    private Long laptopId;

    private String modelNumber;

    private String brand;

    @OneToOne
    private Student student;

}
