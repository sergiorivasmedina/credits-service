package com.project1.credit.repositories;

import com.project1.credit.models.CreditType;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository extends ReactiveMongoRepository<CreditType, String> {
    
}