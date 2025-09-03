package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.service.impl.TransactionServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionServiceImplJpa transactionServiceImplJpa;

    public ResponseEntity<List<Transactions>> getAllTransactions() {
        return null;
    }
    public ResponseEntity<Transactions> getTransactionById(int transactionId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addTransaction(@RequestBody Transactions transaction) {
        try{
            return new ResponseEntity<>(transactionServiceImplJpa.addTransaction(transaction), HttpStatus.CREATED);
        }
        catch(SQLException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    public ResponseEntity<Void> updateTransaction(int transactionId, Transactions transaction) {
        return null;
    }
    public ResponseEntity<Void> deleteTransaction(int transactionId) {
        return null;
    }
}