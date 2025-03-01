package com.example.student_management_lib_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    //id,name,email.gender,country,rating
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "gender",nullable = false)
    private String gender;

    @Column(name = "country",nullable = false)
    private String country;

    @Column(name = "rating",nullable = false)
    private String rating;
}
