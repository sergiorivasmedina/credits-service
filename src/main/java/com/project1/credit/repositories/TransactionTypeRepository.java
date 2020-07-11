package com.project1.credit.repositories;

import com.project1.credit.models.TransactionType;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends ReactiveMongoRepository<TransactionType, String> {
    
}