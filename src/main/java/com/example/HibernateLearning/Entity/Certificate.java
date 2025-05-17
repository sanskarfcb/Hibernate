package com.example.HibernateLearning.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Student_Certificate")
@Getter
@Setter
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateId;
    private String title;
    private String about;
    private String link;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
