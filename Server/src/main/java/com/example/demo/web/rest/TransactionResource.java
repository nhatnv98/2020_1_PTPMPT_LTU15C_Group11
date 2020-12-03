package com.example.demo.web.rest;

import com.example.demo.service.TransactionService;
import com.example.demo.web.vm.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction")
public class TransactionResource {
    private final TransactionService transactionService;
    @Autowired
    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TransactionRequest transactionRequest){
        var transaction = transactionService.create(transactionRequest);
        return ResponseEntity.ok().body(transaction);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id ){
        var transaction = transactionService.getById(id);
        return ResponseEntity.ok().body(transaction);
    }
    @GetMapping
    public ResponseEntity<?> getAllByCardNo(@RequestParam String cardNo){
        var transactions = transactionService.getAllTransByCardNo(cardNo);
        return ResponseEntity.ok().body(transactions);
    }
}
