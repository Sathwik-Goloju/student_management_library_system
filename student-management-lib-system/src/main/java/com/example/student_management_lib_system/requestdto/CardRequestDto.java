package com.example.student_management_lib_system.requestdto;

import com.example.student_management_lib_system.enums.CardStatus;

public class CardRequestDto {

    private CardStatus cardStatus;
    private int studentId;  //FK

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }
}
