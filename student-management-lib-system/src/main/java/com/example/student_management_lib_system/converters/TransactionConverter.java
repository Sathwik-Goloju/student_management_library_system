package com.example.student_management_lib_system.converters;

import com.example.student_management_lib_system.model.Transaction;
import com.example.student_management_lib_system.requestdto.TransactionRequestDto;

public class TransactionConverter {

    public static Transaction convertTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction=new Transaction();
        transaction.setTransactionType(transactionRequestDto.getTransactionType());
        transaction.setFine(transactionRequestDto.getFine());
        transaction.setDueDate(transactionRequestDto.getDueDate());

        return transaction;
    }
}
