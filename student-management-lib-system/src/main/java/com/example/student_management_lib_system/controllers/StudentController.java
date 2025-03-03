package com.example.student_management_lib_system.controllers;
import com.example.student_management_lib_system.model.Student;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;
import com.example.student_management_lib_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // @Response+@Controller
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try {
            String response = studentService.studentSave(studentRequestDto);
            return response;
        }catch (Exception e){
            return "Some error occurred: "+e.getMessage();
        }
    }

    @GetMapping("/findBySemAndDept")
    public List<Student> findStudentSemAndDepartment(String inSem,String inDept){
        List<Student> resp = studentService.findStudentSenAndDept(inSem,inDept);
        return resp;
    }
}
