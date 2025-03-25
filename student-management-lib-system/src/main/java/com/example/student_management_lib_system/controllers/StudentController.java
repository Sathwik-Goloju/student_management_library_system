package com.example.student_management_lib_system.controllers;
import com.example.student_management_lib_system.model.Student;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;
import com.example.student_management_lib_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> findStudentById(@PathVariable int id){
        //ResponseEntity<T> is used when , What kind of return will throw and to handle exception error
        // (or) if any diff return type were there
        try {
            Student student = studentService.findStudentById(id);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
           return  ResponseEntity.internalServerError().body("Something error :"+e.getMessage());
        }
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

    @GetMapping("/findAllByPage")
    public List<Student> findAllStudentsByPageAndSort(@RequestParam int pageNum,@RequestParam int pageSize){
        List<Student> studentList= studentService.findStudentByPageAndSort(pageNum,pageSize);
        return studentList;
    }
//    public List<Student> findAllStudentsByPage(@RequestParam int pageNum,@RequestParam int pageSize){
//        List<Student> studentList= studentService.findStudentByPage(pageNum,pageSize);
//        return studentList;
//    }

    @GetMapping("/findBySemAndDept")
    public List<Student> findStudentSemAndDepartment(String inSem,String inDept){
        List<Student> resp = studentService.findStudentSenAndDept(inSem,inDept);
        return resp;
    }
}
