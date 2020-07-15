package com.bootcamp.credit.repositories;

import com.bootcamp.credit.models.TransactionType;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends ReactiveMongoRepository<TransactionType, String> {
    
}