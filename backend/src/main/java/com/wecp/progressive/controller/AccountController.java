package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Accounts;
import com.wecp.progressive.service.impl.AccountServiceImplArraylist;
import com.wecp.progressive.service.impl.AccountServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private final AccountServiceImplJpa accountServiceImplJpa;
    
    public AccountController(AccountServiceImplJpa accountServiceImplJpa) {
        this.accountServiceImplJpa = accountServiceImplJpa;
    }

    @GetMapping
    public ResponseEntity<List<Accounts>> getAllAccounts() {
        return null;
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Accounts> getAccountById(int accountId) {
        return null;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Accounts>> getAccountsByUser(@PathVariable String userId) throws SQLException {
        int customerId = Integer.parseInt(userId);
        List<Accounts> accounts = accountServiceImplJpa.getAccountsByUser(customerId);
        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }

    @PostMapping
    public ResponseEntity<Integer> addAccount(@RequestBody Accounts accounts) {
        // try{
        //     int accountId=accountServiceImplJpa.addAccount(accounts);
        //     return new ResponseEntity<>(accountId, HttpStatus.CREATED);
        // }
        // catch(Exception e){
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(int accountId, Accounts accounts) {
        return null;
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(int accountId) {
        return null;
    }
}