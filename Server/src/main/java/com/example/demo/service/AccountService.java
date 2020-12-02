package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.web.vm.AccountRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account create(AccountRequest accountRequest){
        var account = new Account();
        account.setFullName(accountRequest.getFullName());
        account.setBalance(accountRequest.getBalance());
        account.setCardNo(accountRequest.getCardNo());
        account.setPhone(accountRequest.getPhone());
        account.setPin(accountRequest.getPin());
        Account result = accountRepository.save(account);
        return result;
    }
    public Account update(int id ,AccountRequest accountRequest){
        var oldAccount = accountRepository.findById(id).get();
        oldAccount.setFullName(accountRequest.getFullName());
        oldAccount.setPin(accountRequest.getPin());
        oldAccount.setPhone(accountRequest.getPhone());
        oldAccount.setBalance(accountRequest.getBalance());
        var updated = accountRepository.save(oldAccount);
        return updated;
    }
    public void delete(int id){
        var account = accountRepository.findById(id).get();
        account.setDeleted(true);
        accountRepository.save(account);
    }
    public Account getByID(int id){
        return accountRepository.findById(id).get();
    }
    public List<Account> getAll(){
        return accountRepository.findAllByAndDeletedFalse();
    }
}
