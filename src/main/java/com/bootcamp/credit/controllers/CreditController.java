package com.bootcamp.credit.controllers;

import java.util.List;

import com.bootcamp.credit.models.Credit;
import com.bootcamp.credit.services.CreditService;

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
public class CreditController {
    
    @Autowired
    private CreditService creditService;
    
    @GetMapping(value = "/credits")
    public @ResponseBody Flux<Credit> getAllCredits() {
        // list all data in credit collection
        return creditService.findAll();
    }

    @PostMapping(value = "/credit/new")
    public Mono<Credit> newCredit(@RequestBody Credit newCredit) {
        // adding a new credit to the collection
        return creditService.save(newCredit);
    }

    @PutMapping(value = "/credit/{creditId}")
    public Mono <ResponseEntity<Credit>> updateCredit(@PathVariable(name = "creditId") String creditId, @RequestBody Credit credit) {
        return creditService.findById(creditId)
            .flatMap(existingCredit -> {
                return creditService.save(credit);
            })
            .map(updateCredit -> new ResponseEntity<>(updateCredit, HttpStatus.OK))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/credit/{creditId}")
    public Mono<ResponseEntity<Void>> deleteCreditType(@PathVariable(name = "creditId") String creditId) {
        return creditService.findById(creditId)
            .flatMap(existingCredit ->
                creditService.delete(existingCredit)
                    .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))) 
            )
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Pay credit products
    @PutMapping(value = "/credit/pay/{creditId}/{amount}/{transactionId}")
    public Mono<ResponseEntity<Credit>> payProduct(@PathVariable(name = "creditId") String creditId, @PathVariable(name = "amount") Double amount,
            @PathVariable(name = "transactionId") String transactionId) {

        return creditService.findById(creditId)
            .flatMap(existingCredit -> {
                //update available amount and consumed amount
                existingCredit.setAvailableAmount(existingCredit.getAvailableAmount() + amount);
                existingCredit.setConsumedAmount(existingCredit.getConsumedAmount() - amount);

                //add new transaction to the list
                List<String> transactionList = existingCredit.getCreditTransactions();
                transactionList.add(transactionId);
                existingCredit.setCreditTransactions(transactionList);

                return creditService.save(existingCredit);
            })
            .map(updateCredit -> new ResponseEntity<>(updateCredit, HttpStatus.OK))
            .defaultIfEmpty((new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }

    //Charge credit consumption
    @PutMapping(value = "/credit/charge/{creditId}/{amount}/{transactionId}")
    public Mono<ResponseEntity<Credit>> chargeProduct(@PathVariable(name = "creditId") String creditId, @PathVariable(name = "amount") Double amount,
            @PathVariable(name = "transactionId") String transactionId ) {

        return creditService.findById(creditId)
            .flatMap(existingCredit -> {
                Double available = existingCredit.getAvailableAmount();
                Double consumed = existingCredit.getConsumedAmount();

                if ((consumed + amount) < existingCredit.getLimit()) {
                    //update available amount and consumed amount
                    existingCredit.setAvailableAmount(available - amount);
                    existingCredit.setConsumedAmount(consumed + amount);

                    //add new transaction to the list
                    List<String> transactionList = existingCredit.getCreditTransactions();
                    transactionList.add(transactionId);
                    existingCredit.setCreditTransactions(transactionList);
                }
                return creditService.save(existingCredit); //debería mandar un mensaje de que el monto no se pudo actualizar
            })
            .map(updateCredit -> new ResponseEntity<>(updateCredit, HttpStatus.OK))
            .defaultIfEmpty((new ResponseEntity<>(HttpStatus.NOT_FOUND)));
    }
}