package com.project1.credit.repositories;

import com.project1.credit.models.Transaction;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{
    
}