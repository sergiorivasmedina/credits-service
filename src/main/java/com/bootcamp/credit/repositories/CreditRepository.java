package com.bootcamp.credit.repositories;

import com.bootcamp.credit.models.Credit;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credit, String> {
    
    Flux<Credit> findByIdCustomer(String idCustomer);

    Mono<Credit> findByIdCustomerAndExpiredDebt(String customerId, int statusDebt);
}