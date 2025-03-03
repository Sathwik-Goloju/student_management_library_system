package com.example.student_management_lib_system.service;

import com.example.student_management_lib_system.converters.StudentConverter;
import com.example.student_management_lib_system.enums.CardStatus;
import com.example.student_management_lib_system.model.Card;
import com.example.student_management_lib_system.model.Student;
import com.example.student_management_lib_system.repository.StudentRepository;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    //example - custom query using JPA
    public List<Student> findStudentSenAndDept(String inSem, String inDept){
        List<Student> students= studentRepository.findBySemAndDept(inSem,inDept);
        return students;
    }
}
