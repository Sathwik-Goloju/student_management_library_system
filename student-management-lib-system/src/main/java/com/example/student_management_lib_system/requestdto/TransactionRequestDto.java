package com.example.student_management_lib_system.requestdto;

import com.example.student_management_lib_system.enums.TransactionType;
import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class TransactionRequestDto {
    private TransactionType transactionType;
    private Date dueDate;
    private double fine;
    private int bookId;
    private int cardId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
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
