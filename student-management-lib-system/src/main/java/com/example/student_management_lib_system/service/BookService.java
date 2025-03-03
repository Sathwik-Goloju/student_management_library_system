package com.example.student_management_lib_system.service;

import com.example.student_management_lib_system.converters.BookConverter;
import com.example.student_management_lib_system.model.Author;
import com.example.student_management_lib_system.model.Book;
import com.example.student_management_lib_system.model.Card;
import com.example.student_management_lib_system.repository.AuthorRepository;
import com.example.student_management_lib_system.repository.BookRepository;
import com.example.student_management_lib_system.repository.CardRepository;
import com.example.student_management_lib_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String saveBook(BookRequestDto bookRequestDto){
        Book book= BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        //Here we need to add authorId and CardId (FKs of table)
        // for that add objects of card and author ot get them
        Card card = cardRepository.findById(bookRequestDto.getCardIt()).get();
        book.setCard(card);
        Author author= authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        bookRepository.save(book);
        return "book saved successfully";
    }
}
