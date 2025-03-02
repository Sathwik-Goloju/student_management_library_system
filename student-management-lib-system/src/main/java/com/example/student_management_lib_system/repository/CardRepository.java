package com.example.student_management_lib_system.repository;

import com.example.student_management_lib_system.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository  extends JpaRepository<Card,Integer> {
}
