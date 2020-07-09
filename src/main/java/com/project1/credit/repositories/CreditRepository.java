package com.project1.credit.repositories;

import com.project1.credit.models.Credit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepository extends MongoRepository<Credit, Integer> {
    
}