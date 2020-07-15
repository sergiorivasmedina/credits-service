package com.bootcamp.credit.controllers;

import com.bootcamp.credit.models.TransactionType;
import com.bootcamp.credit.repositories.TransactionTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class TransactionTypeController {
    
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @GetMapping(value = "/transaction/types")
    public @ResponseBody Flux<TransactionType> getAllTrasactionTypes() {
        // list all data in transaction type collection
        return transactionTypeRepository.findAll();
    }

    @PostMapping(value="/transaction/type/new")
    public Mono<TransactionType> newTransactionType(@RequestBody TransactionType type) {
        // aading a new transaction type
        return transactionTypeRepository.save(type);
    }

    @PutMapping(value="transaction/type/{typeId}")
    public Mono<ResponseEntity<TransactionType>> updateTrasactionType(@PathVariable(name = "typeId") String typeId, @RequestBody TransactionType type) {
        // update a transaction type
        return transactionTypeRepository.findById(typeId)
                .flatMap(existingType -> {
                    return transactionTypeRepository.save(type);
                })
                .map(updateType -> new ResponseEntity<>(updateType, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/transaction/type/{typeId}")
    public Mono<ResponseEntity<Void>> deleteTransactionType(@PathVariable(name = "typeId") String typeId) {
        return transactionTypeRepository.findById(typeId)
                .flatMap(existingType ->
                    transactionTypeRepository.delete(existingType)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}