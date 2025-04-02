package com.example.student_management_lib_system.service;

import com.example.student_management_lib_system.converters.AuthorConverter;
import com.example.student_management_lib_system.model.Author;
import com.example.student_management_lib_system.repository.AuthorRepository;
import com.example.student_management_lib_system.requestdto.AuthorRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String saveAuthor(AuthorRequestDto authorRequestDto){
        Author author= AuthorConverter.convertAuthorRequestDtoIntoAuthor(authorRequestDto);
        authorRepository.save(author);
        return "Author Saved Successuflly";
    }


}
