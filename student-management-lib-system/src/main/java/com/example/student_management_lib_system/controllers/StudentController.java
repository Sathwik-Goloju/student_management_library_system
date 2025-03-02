package com.example.student_management_lib_system.controllers;

import com.example.student_management_lib_system.model.Student;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;
import com.example.student_management_lib_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Response+@Controller
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response= studentService.studentSave(studentRequestDto);
        return response;
    }
}
