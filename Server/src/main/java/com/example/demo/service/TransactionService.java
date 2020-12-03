package com.example.demo.service;

import com.example.demo.domain.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.web.exception.BadRequestAlertException;
import com.example.demo.web.vm.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public Transaction create(TransactionRequest transactionRequest) {
        var account1 = accountRepository.findAccountByCardNoAndDeletedFalse(transactionRequest.getCardNo1());
        var account2 = accountRepository.findAccountByCardNoAndDeletedFalse(transactionRequest.getCardNo2());
        if (account2 == null) {
            //TODO return exception
            throw new BadRequestAlertException("Không tồn tại số tài khoản", "Account", "500");
        }
        var transaction = new Transaction();
        transaction.setCardNo1(transactionRequest.getCardNo1());
        transaction.setCardNo2(transactionRequest.getCardNo2());
        transaction.setType(transactionRequest.getType());
        transaction.setMoney(transactionRequest.getMoney());
        var result = account1.getBalance().compareTo(transactionRequest.getMoney());
        switch (transactionRequest.getType()) {
            case DEPOSIT:
                account1.setBalance(account1.getBalance().add(transactionRequest.getMoney()));
                accountRepository.save(account1);
                break;
            case TRANSFER:
                if (result == -1) {
                    //TODO return exception
                    throw new BadRequestAlertException("Không đủ số dư", "Transaction", "500");
                }
                account1.setBalance(account1.getBalance().subtract(transactionRequest.getMoney()));
                accountRepository.save(account1);
                account2.setBalance(account2.getBalance().add(transactionRequest.getMoney()));
                accountRepository.save(account2);
                break;
            case WITHDRAW:
                if (result == -1) {
                    //TODO return exception
                    throw new BadRequestAlertException("Không đủ số dư", "Transaction", "500");
                }
                account1.setBalance(account1.getBalance().subtract(transactionRequest.getMoney()));
                account2.setBalance(account2.getBalance().add(transactionRequest.getMoney()));
                accountRepository.save(account1);
                accountRepository.save(account2);
                break;
        }
        var transResult = transactionRepository.save(transaction);
        return transResult;
    }

    public Transaction getById(int id) {
        var transaction = transactionRepository.findTransactionByIdAndDeletedFalse(id);
        return transaction;
    }

    public List<Transaction> getAllTransByCardNo(String cardNo) {
        var transactions = transactionRepository.findAllByCardNo1AndDeletedFalse(cardNo);
        return transactions;
    }
}
