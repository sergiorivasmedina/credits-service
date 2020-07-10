package com.project1.credit.controllers;

import java.util.List;

import com.project1.credit.models.Credit;
import com.project1.credit.repositories.CreditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CreditController {
    
    @Autowired
    private CreditRepository creditRepository;
    
    @GetMapping(value = "/credits")
    public @ResponseBody List<Credit> getAllCredits() {
        // list all data in credit collection
        return creditRepository.findAll();
    }

    @PutMapping(value = "/credit/new")
    public @ResponseBody Credit newCredit(@RequestBody Credit newCredit) {
        // adding a new credit to the collection
        return creditRepository.save(newCredit);
    }

    @PostMapping(value = "/credit/update")
    public @ResponseBody Credit updateCredit(@RequestBody Credit credit) {
        // modifying credit fields
        return creditRepository.save(credit);
    }

    @DeleteMapping(value = "/credit/delete")
    public void deleteCredit(@RequestBody Credit credit) {
        try {
            creditRepository.delete(credit);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}