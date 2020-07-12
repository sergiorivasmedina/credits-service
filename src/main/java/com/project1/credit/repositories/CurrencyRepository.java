package com.project1.credit.repositories;

import com.project1.credit.models.Currency;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends ReactiveMongoRepository<Currency, String> {
    
}