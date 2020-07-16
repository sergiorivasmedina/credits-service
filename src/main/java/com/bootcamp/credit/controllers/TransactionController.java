package com.bootcamp.credit.controllers;

import com.bootcamp.credit.models.Transaction;
import com.bootcamp.credit.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/transactions")
    public @ResponseBody Flux<Transaction> getAllTrasactions() {
        // list all data in transaction collection
        return transactionService.findAll();
    }

    @PostMapping(value="/transaction/new")
    public Mono<Transaction> newTransaction(@RequestBody Transaction transaction) {
        // aading a new transaction
        return transactionService.save(transaction);
    }

    @PutMapping(value="transaction/{transactionId}")
    public Mono<ResponseEntity<Transaction>> updateTrasaction(@PathVariable(name = "transactionId") String transactionId, @RequestBody Transaction transaction) {
        // update a transaction type
        return transactionService.findById(transactionId)
                .flatMap(existingTransaction -> {
                    return transactionService.save(transaction);
                })
                .map(updateTransaction -> new ResponseEntity<>(updateTransaction, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/transaction/{transactionId}")
    public Mono<ResponseEntity<Void>> deleteTransactionType(@PathVariable(name = "transactionId") String transactionId) {
        return transactionService.findById(transactionId)
                .flatMap(existingTransaction ->
                    transactionService.delete(existingTransaction)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}