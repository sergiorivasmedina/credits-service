package com.bootcamp.credit.repositories;

import com.bootcamp.credit.models.Currency;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends ReactiveMongoRepository<Currency, String> {
    
}