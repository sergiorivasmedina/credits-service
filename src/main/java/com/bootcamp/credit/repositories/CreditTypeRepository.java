package com.bootcamp.credit.repositories;

import com.bootcamp.credit.models.CreditType;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditTypeRepository extends ReactiveMongoRepository<CreditType, String> {
    
}