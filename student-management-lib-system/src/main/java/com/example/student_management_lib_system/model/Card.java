package com.example.student_management_lib_system.model;

import com.example.student_management_lib_system.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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
