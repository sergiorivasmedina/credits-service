package com.project1.credit.repositories;

import com.project1.credit.models.CreditType;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditTypeRepository extends MongoRepository<CreditType, Integer> {
    
}