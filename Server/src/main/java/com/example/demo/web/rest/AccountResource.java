package com.example.demo.web.rest;

import com.example.demo.service.AccountService;
import com.example.demo.web.vm.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountResource {
    private final AccountService accountService;
    @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest){
        var account = accountService.create(accountRequest);
        return ResponseEntity.ok().body(account);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable int id, @RequestBody AccountRequest accountRequest){
        var account =  accountService.update(id,accountRequest);
        return ResponseEntity.ok().body(account);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable int id){
        accountService.delete(id);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable int id){
        var account = accountService.getByID(id);
        return ResponseEntity.ok().body(account);
    }
    @GetMapping
    public ResponseEntity<?> getAll(){
        var accounts = accountService.getAll();
        return ResponseEntity.ok().body(accounts);
    }
}
