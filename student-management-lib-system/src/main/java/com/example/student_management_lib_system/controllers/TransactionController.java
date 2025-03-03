package com.example.student_management_lib_system.controllers;

import com.example.student_management_lib_system.requestdto.TransactionRequestDto;
import com.example.student_management_lib_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // @Response+@Controller
@RequestMapping("/transaction/api")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(TransactionRequestDto transactionRequestDto){
        try {
            String resp = transactionService.saveTransactionIntoDB(transactionRequestDto);
        return resp;
        } catch (Exception e) {
            return "Error at :"+e.getMessage();
        }
    }
}
