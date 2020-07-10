package com.project1.credit.controllers;

import java.util.List;

import com.project1.credit.models.CreditType;
import com.project1.credit.repositories.CreditTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class CreditTypeController {

    @Autowired
    private CreditTypeRepository creditTypeRepository;

    @GetMapping(value = "/credit/types")
    public @ResponseBody List<CreditType> getAllTypes() {
        return creditTypeRepository.findAll();
    }

    @PutMapping(value = "/credit/type/new")
    public @ResponseBody CreditType newCreditType(@RequestBody CreditType newType) {
        return creditTypeRepository.save(newType);
    }

    @PostMapping(value = "/credit/type/update")
    public @ResponseBody CreditType updateCreditType(@RequestBody CreditType type) {
        // updating a credit type with new information
        return creditTypeRepository.save(type);
    }

    @DeleteMapping(value = "/credit/type/delete")
    public void deleteCreditType(@RequestBody CreditType type) {
        creditTypeRepository.delete(type);
    }
}