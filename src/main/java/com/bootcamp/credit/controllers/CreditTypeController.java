package com.bootcamp.credit.controllers;

import com.bootcamp.credit.models.CreditType;
import com.bootcamp.credit.repositories.CreditTypeRepository;

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
public class CreditTypeController {

    @Autowired
    private CreditTypeRepository creditTypeRepository;

    @GetMapping(value = "/credit/types")
    public @ResponseBody Flux<CreditType> getAllTypes() {
        return creditTypeRepository.findAll();
    }

    @GetMapping(value = "/credit/types/{id}")
    public @ResponseBody Mono<CreditType> getOneType(@PathVariable(value = "id") String creditTypeId) {
        return creditTypeRepository.findById(creditTypeId);
    }

    @PostMapping(value = "/credit/type/new")
    public Mono<CreditType> newCreditType(@RequestBody CreditType creditType) {
        return creditTypeRepository.save(creditType);
    }

    @PutMapping(value = "/credit/type/{id}")
    public Mono<ResponseEntity<CreditType>> updateCreditType(@PathVariable(value = "id") String creditTypeId, @RequestBody CreditType creditType) {
        return creditTypeRepository.findById(creditTypeId)
                .flatMap(existingCreditType -> {
                    existingCreditType.setName(creditType.getName());
                    return creditTypeRepository.save(existingCreditType);
                })
                .map(updateCreditType -> new ResponseEntity<>(updateCreditType, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(value = "/credit/type/{id}")
    public Mono<ResponseEntity<Void>> deleteCreditType(@PathVariable(value = "id") String creditTypeId) {
        return creditTypeRepository.findById(creditTypeId)
                .flatMap(existingCreditType -> 
                        creditTypeRepository.delete(existingCreditType)
                            .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                        )
                        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}