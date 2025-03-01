package com.example.student_management_lib_system.model;

import com.example.student_management_lib_system.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "card_status",nullable = false)
    @Enumerated(value = EnumType.STRING)  //It will convert enum value to string and store in DB
    private CardStatus cardStatus;

    @Column(name = "crated_date",nullable = false)
    @CreationTimestamp  //It automatically creates date&time
    private Date createdDate;

    @Column(name = "updated_date",nullable = false)
    @UpdateTimestamp    //It automatically updates date&time
    private Date updatedDate;

    @OneToOne
    @JoinColumn  // it joins the primary key of student table into card table as foreign key
    private Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksListByCard=new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction> transactionsByCard=new ArrayList<>();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBooksListByCard() {
        return booksListByCard;
    }

    public void setBooksListByCard(List<Book> booksListByCard) {
        this.booksListByCard = booksListByCard;
    }

    public List<Transaction> getTransactionsByCard() {
        return transactionsByCard;
    }

    public void setTransactionsByCard(List<Transaction> transactionsByCard) {
        this.transactionsByCard = transactionsByCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
