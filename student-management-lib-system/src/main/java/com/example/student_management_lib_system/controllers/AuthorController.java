package com.example.student_management_lib_system.controllers;

import com.example.student_management_lib_system.requestdto.AuthorRequestDto;
import com.example.student_management_lib_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Response+@Controller
@RequestMapping("/author/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        try {
            String resp = authorService.saveAuthor(authorRequestDto);
            return resp;
        } catch (Exception e) {
            return "Error occurred at :"+e.getMessage();
        }
    }
}
