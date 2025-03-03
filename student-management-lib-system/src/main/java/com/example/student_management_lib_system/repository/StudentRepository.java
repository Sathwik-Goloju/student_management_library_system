package com.example.student_management_lib_system.repository;

import com.example.student_management_lib_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    //Integer represents primary key of Student model class
    //below Customized queries(2 types)
    //1-With JPA support - using attributes or fields
    public Student findByEmail(String inputEmail);
    public List<Student> findByDept(String inDept);

    //find by 2 fields
    public List<Student> findBySemAndDept(String inputSem,String inputDep);
    public List<Student> findBySemOrDept(String inputSem,String inpDep);

    //2 - With own sql queries
    @Query(nativeQuery = true,value = "select * from student_management_lib_system.student where dept=:inDept")
    public List<Student> getStudentByDept(String inDept);

    @Query(nativeQuery = true,value = "select * from student_management_lib_system.student where email=:inEmail")
    public List<Student> getStudentByEmail(String inEmail);
}
