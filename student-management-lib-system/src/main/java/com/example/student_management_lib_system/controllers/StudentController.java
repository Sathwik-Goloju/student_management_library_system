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

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable int id){
            Student student = studentService.findStudentById(id);
            return student;
    }

    @GetMapping("findAll")
    public List<Student> findAllStudents(){
        List<Student> studentList= studentService.findAllStudents();
        return studentList;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String resp=studentService.deleteStudentById(id);
        return resp;
    }

    @PutMapping("/update/{id}")
    public String updateStudentById(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        String resp = studentService.updateStudent(id,studentRequestDto);
        return resp;
    }

    @GetMapping("/count")
    public String countStudents(){
        String resp=studentService.countStudents();
        return resp;
    }

    @GetMapping("/findBySemAndDept")
    public List<Student> findStudentSemAndDepartment(String inSem,String inDept){
        List<Student> resp = studentService.findStudentSenAndDept(inSem,inDept);
        return resp;
    }
}
