package com.example.student_management_lib_system.controllers;

import com.example.student_management_lib_system.requestdto.BookRequestDto;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;
import com.example.student_management_lib_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Response+@Controller
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        try {
            String resp = bookService.saveBook(bookRequestDto);
            return resp;
          } catch (Exception e) {
            return "Error at :"+e.getMessage();
        }
    }

}
