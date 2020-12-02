package com.example.demo.service;

import com.example.demo.domain.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.web.vm.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository  accountRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }
    @Transactional
    public Transaction create(TransactionRequest transactionRequest){
        var account1 = accountRepository.findAccountByCardNoAndDeletedFalse(transactionRequest.getCardNo1());
        var account2 = accountRepository.findAccountByCardNoAndDeletedFalse(transactionRequest.getCardNo2());
        if(account2 == null){
            //TODO return exception
            return null;
        }
        var transaction = new Transaction();
        transaction.setCardNo1(transactionRequest.getCardNo1());
        transaction.setCardNo2(transactionRequest.getCardNo2());
        transaction.setType(transactionRequest.getType());
        transaction.setMoney(transactionRequest.getMoney());
        var result = transactionRepository.save(transaction);
        return result;
    }
    public Transaction getById(String cardNo,int id){
        var transaction = transactionRepository.findTransactionByCardNo1AndIdAndDeletedFalse(cardNo,id);
        return transaction;
    }
    public List<Transaction> getAllTransByCardNo(String cardNo){
        var transactions = transactionRepository.findAllByCardNo1AndDeletedFalse(cardNo);
        return transactions;
    }
}
