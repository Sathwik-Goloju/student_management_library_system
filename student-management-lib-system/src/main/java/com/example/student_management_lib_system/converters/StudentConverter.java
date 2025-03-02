package com.example.student_management_lib_system.converters;

import com.example.student_management_lib_system.model.Student;
import com.example.student_management_lib_system.requestdto.StudentRequestDto;

public class StudentConverter {

    //converter - converts dto request into model class to save data into DB
    //It is kind of medium/mediater which helps in converting DTO to model class object

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto){
        Student student= new Student();
        student.setAddress(studentRequestDto.getAddress());
        student.setPhone(studentRequestDto.getPhone());
        student.setDept(studentRequestDto.getDept());
        student.setDob(studentRequestDto.getDob());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());
        student.setName(studentRequestDto.getName());
        student.setSem(studentRequestDto.getSem());

        return  student;
    }
}
