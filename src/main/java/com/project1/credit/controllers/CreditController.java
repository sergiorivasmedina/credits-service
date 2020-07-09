package com.project1.credit.controllers;

import java.util.List;

import com.project1.credit.models.Credit;
import com.project1.credit.models.CreditType;
import com.project1.credit.repositories.CreditRepository;
import com.project1.credit.repositories.CreditTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CreditController {
    
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private CreditTypeRepository creditTypeRepository;

    // Credits

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

    // Credits types
    
    @GetMapping(value = "/credit/types")
    public @ResponseBody List<CreditType> getAllTypes() {
        return creditTypeRepository.findAll();
    }

    @PutMapping(value = "/credit/type/new")
    public @ResponseBody CreditType newCreditType(@RequestBody CreditType newType) {
        return creditTypeRepository.save(newType);
    }
}