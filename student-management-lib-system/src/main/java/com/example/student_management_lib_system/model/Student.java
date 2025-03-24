package com.example.student_management_lib_system.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

//to create a table, we write annotation @entity,@table
@Entity
@Table(name = "student")
public class Student {

    //create attributes
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id generated seperate for each table,Auto-generate ids continuously for all tables.UUId-generates ids randomly
    private int id;

    @Column(name = "name",nullable = false)   //column name for student table
    private String name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "sem",nullable = false)
    private String sem;

    @Column(name = "dept",nullable = false)
    private String dept;

    @JsonManagedReference
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)  //Cascade-when we do operations(add/delete) that will takes place in card also
    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    //mention the getters and setters using generate option for above fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
