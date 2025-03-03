package com.example.student_management_lib_system.service;

import com.example.student_management_lib_system.converters.TransactionConverter;
import com.example.student_management_lib_system.model.Book;
import com.example.student_management_lib_system.model.Card;
import com.example.student_management_lib_system.model.Transaction;
import com.example.student_management_lib_system.repository.BookRepository;
import com.example.student_management_lib_system.repository.CardRepository;
import com.example.student_management_lib_system.repository.TransactionRepository;
import com.example.student_management_lib_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;

    public String saveTransactionIntoDB(TransactionRequestDto transactionRequestDto){
        Transaction transaction= TransactionConverter.convertTransactionRequestDtoIntoTransaction(transactionRequestDto);

        //adding FKs bookid and cardId
        Book book = bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);
        Card card= cardRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setCard(card);

        transactionRepository.save(transaction);
        return "Transaction saved succeed";
    }
}
