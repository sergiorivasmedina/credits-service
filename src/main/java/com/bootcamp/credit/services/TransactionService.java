package com.bootcamp.credit.services;

import com.bootcamp.credit.models.Transaction;
import com.bootcamp.credit.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Mono<Transaction> save(Transaction newtransaction) {
        return transactionRepository.save(newtransaction);
    }

    public Mono<Transaction> findById(String transactionId) {
        return transactionRepository.findById(transactionId);
    }

    public Mono<Void> delete(Transaction transaction) {
        return transactionRepository.delete(transaction);
    }
}