package com.example.student_management_lib_system.converters;

import com.example.student_management_lib_system.model.Author;
import com.example.student_management_lib_system.requestdto.AuthorRequestDto;

public class AuthorConverter {

    public static Author convertAuthorRequestDtoIntoAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setRating(authorRequestDto.getRating());
        author.setCountry(authorRequestDto.getCountry());
        author.setGender(authorRequestDto.getGender());
        return author;
    }
}
