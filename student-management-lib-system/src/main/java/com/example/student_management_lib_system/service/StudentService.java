package com.example.student_management_lib_system.service;

import com.example.student_management_lib_system.converters.StudentConverter;
import com.example.student_management_lib_system.enums.CardStatus;
import com.example.student_management_lib_system.model.Card;
import com.example.student_management_lib_system.model.Student;
import com.example.student_management_lib_system.repository.StudentRepository;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public String studentSave(StudentRequestDto studentRequestDto){

        // first need to convert StudentRequestDto into Student, So call studentConverter directly
       Student student= StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);
       //whenever student is saved then card also should saved/created at same time
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);
        student.setCard(card);

        //here no need of cardRepo as we added cascade
       studentRepository.save(student);
       return "Student & Card saved successfully";
    }

    public Student findStudentById(int id){
        //To handle the null value, we use optional returns student else returns null
       Optional<Student> studentOptional= studentRepository.findById(id);
       if(studentOptional.isPresent()){
           return studentOptional.get();
           //return studentOptional.orElse(null);
       }else{
           throw new RuntimeException("Student not found for id :"+id);
       }
    }

    public List<Student> findAllStudents(){
       List<Student> studentList= studentRepository.findAll();
       return studentList;
    }
    public String deleteStudentById(int id){
        studentRepository.deleteById(id);
        return "Deleted successfully";
    }

    //While updating we take id, dto object
    public String updateStudent(int id,StudentRequestDto studentRequestDto){
        Student student=findStudentById(id);
        if(student!=null){
            //TO examine updated few fields below of student
            student.setName(studentRequestDto.getName());
            student.setSem((studentRequestDto.getSem()));
            student.setPhone(studentRequestDto.getPhone());
            student.setEmail(studentRequestDto.getEmail());

            studentRepository.save(student);
            return  "student updated with fields";
        }
        else{
            return "Cannot be updated";
        }
    }

    public String countStudents(){
        long cnt = studentRepository.count();
        return "Total no os students :"+cnt;
    }

    //pagination - fetching the data/records in form of pages
    //This takes 2 inputs (pagNumber,pageSize) pagNumber- the page want to see and pageSize-total records in each page
    //ex - say total 11 pages there, pageSize is 2; then
    //0st page : 1-2, 1st page:3-4.......5page:11
    //if only pagination wants then use
//    public List<Student> findStudentByPage(int pageNumber,int pageSize){
//        List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNumber,pageSize)).getContent();
//        return studentList;
//    }
    public List<Student> findStudentByPageAndSort(int pageNumber,int pageSize){
       List<Student> studentList = studentRepository.findAll(PageRequest.of(pageNumber,pageSize, Sort.by("name").ascending())).getContent();
       return studentList;
    }

    //sorting


    //example - custom query using JPA
    public List<Student> findStudentSenAndDept(String inSem, String inDept){
        List<Student> student= studentRepository.findBySemAndDept(inSem,inDept);
        return student;
    }
}
