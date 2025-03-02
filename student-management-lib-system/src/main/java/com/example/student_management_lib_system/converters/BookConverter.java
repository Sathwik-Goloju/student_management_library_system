package com.example.student_management_lib_system.converters;

import com.example.student_management_lib_system.model.Book;
import com.example.student_management_lib_system.requestdto.BookRequestDto;

public class BookConverter {
    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book=new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setRackNo(bookRequestDto.getRackNo());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        return book;
    }
}
