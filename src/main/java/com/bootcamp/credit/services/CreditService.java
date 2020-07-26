package com.bootcamp.credit.services;

import java.util.Date;

import com.bootcamp.credit.dto.CreditDTO;
import com.bootcamp.credit.models.Credit;
import com.bootcamp.credit.repositories.CreditRepository;
import com.bootcamp.credit.repositories.CreditTypeRepository;
import com.bootcamp.credit.repositories.CurrencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService {
    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private CreditTypeRepository creditTypeRepository;
    @Autowired
    private CurrencyRepository currencyRepository;

    public Flux<Credit> findAll() {
        return creditRepository.findAll();
    }

    public Mono<? extends Credit> save(Credit newCredit) {
        return creditRepository.save(newCredit);
    }

    public Mono<Credit> findById(String creditId) {
        return creditRepository.findById(creditId);
    }

    public Mono<Void> delete(Credit credit) {
        return creditRepository.delete(credit);
    }

    public Flux<Credit> searchCreditByCustomerId(String customerId) {
        return creditRepository.findByIdCustomer(customerId);
    }

    public Mono<Credit> findByExpiredDebt(String customerId, int statusDebt) {
        return creditRepository.findByIdCustomerAndExpiredDebt(customerId, statusDebt);
    }

    public Flux<CreditDTO> findBetweenDates(Date initialDate, Date endDate, String bankId) {
        return creditRepository.findAll()
                .filter(credit -> credit.getBankId() != null && credit.getCreatedAt() != null &&
                        credit.getBankId().compareTo(bankId) == 0 && credit.getCreatedAt().compareTo(initialDate) > 0 &&
                        credit.getCreatedAt().compareTo(endDate) < 0)
                .flatMap(credit -> {
                    return creditTypeRepository.findById(credit.getCreditType())
                            .map(type -> {
                                String expiredDebt;
                                if (credit.getExpiredDebt() == 1) {
                                    expiredDebt = "Tiene deuda vencida.";
                                } else {
                                    expiredDebt = "No tiene deuda vencida.";
                                }
                                return new CreditDTO(credit, type.getName(), expiredDebt);
                            })
                            .switchIfEmpty(Mono.just(new CreditDTO(credit, "No se encontró nombre.", null)));
                })
                .flatMap(creditDto -> {
                    return currencyRepository.findById(creditDto.getCurrencyName())
                            .map(currency -> {
                                return new CreditDTO(creditDto, currency.getName());
                            })
                            .switchIfEmpty(Mono.just(new CreditDTO(creditDto, "No se encontró moneda.")));
                });
    }
}