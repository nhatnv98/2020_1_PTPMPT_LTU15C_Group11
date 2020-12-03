package com.example.demo.repository;

import com.example.demo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    Transaction findTransactionByCardNo1AndIdAndDeletedFalse(String cardNo,Integer id);
    List<Transaction> findAllByCardNo1AndDeletedFalse(String cardNo);
    Transaction findTransactionByIdAndDeletedFalse(Integer id);
}
