package com.bootcamp.credit.services;

import com.bootcamp.credit.models.Credit;
import com.bootcamp.credit.repositories.CreditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService {
    @Autowired
    private CreditRepository creditRepository;

    public Flux<Credit> findAll() {
        return creditRepository.findAll();
    }

    public Mono<Credit> save(Credit newCredit) {
        return creditRepository.save(newCredit);
    }

    public Mono<Credit> findById(String creditId) {
        return creditRepository.findById(creditId);
    }

    public Mono<Void> delete(Credit credit) {
        return creditRepository.delete(credit);
    }

    public Flux<Credit> searchCreditByCustomerId(String customerId) {
        return creditRepository.findByIdCustomer(customerId);
    }
}