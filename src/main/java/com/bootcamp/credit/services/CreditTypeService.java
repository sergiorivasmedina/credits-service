package com.bootcamp.credit.services;

import com.bootcamp.credit.models.CreditType;
import com.bootcamp.credit.repositories.CreditTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditTypeService {
    @Autowired
    private CreditTypeRepository creditTypeRepository;

    public Flux<CreditType> findAll() {
        return creditTypeRepository.findAll();
    }

    public Mono<CreditType> save(CreditType newCreditType) {
        return creditTypeRepository.save(newCreditType);
    }

    public Mono<CreditType> findById(String creditTypeId) {
        return creditTypeRepository.findById(creditTypeId);
    }

    public Mono<Void> delete(CreditType creditType) {
        return creditTypeRepository.delete(creditType);
    }
}