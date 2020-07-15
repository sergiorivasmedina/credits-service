package com.bootcamp.credit.repositories;

import com.bootcamp.credit.models.Transaction;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String>{
    
}