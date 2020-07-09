package com.project1.credit.controllers;

import java.util.List;

import com.project1.credit.models.Credit;
import com.project1.credit.repositories.CreditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}