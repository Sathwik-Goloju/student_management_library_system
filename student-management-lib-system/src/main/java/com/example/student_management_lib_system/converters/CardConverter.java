package com.example.student_management_lib_system.converters;

import com.example.student_management_lib_system.model.Card;
import com.example.student_management_lib_system.requestdto.CardRequestDto;

public class CardConverter {
    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card= new Card();
        card.setCardStatus(cardRequestDto.getCardStatus());
        return card;
    }
}
