package com.example.student_management_lib_system.model;

import com.example.student_management_lib_system.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Transaction    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "transactionType")
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "transactionDate")
    @CreationTimestamp
    private Date transactionDate;

    @Column(name = "dueDate")
    private Date dueDate;

    @Column(name = "fine")
    private double fine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
