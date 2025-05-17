package com.example.HibernateLearning.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name = "Name" , unique = true , length = 20)
    private String name;

    @Column(name = "College" , length = 100)
    private String college_name;

    @Column(name = "PhoneNo." , unique = true)
    private String phone;

    @Column(name = "Father's Name")
    private String fathername;

    @Column(name = "Status")
    private boolean active;

    private String about;

    @OneToMany (mappedBy = "student" , fetch =FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Certificate> certificates = new ArrayList<>();

}
