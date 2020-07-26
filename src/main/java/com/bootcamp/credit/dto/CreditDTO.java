package com.bootcamp.credit.dto;

import java.util.Date;

import com.bootcamp.credit.models.Credit;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditDTO {
    private String creditId;
    private String customerId;
    private String currencyName;
    private Double availableAmount;
    private Double comsumedAmount;
    private Double limit;
    private String creditTypeName;
    private String expiredDebt;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date createdAt;

    public CreditDTO(Credit credit, String creditTypeName, String expiredDebt) {
        this.creditId = credit.getIdCredit();
        this.customerId = credit.getIdCustomer();
        this.availableAmount = credit.getAvailableAmount();
        this.comsumedAmount = credit.getConsumedAmount();
        this.limit = credit.getLimit();
        this.createdAt = credit.getCreatedAt();
        //epired debt
        this.expiredDebt = expiredDebt;
        //credit type name
        this.creditTypeName = creditTypeName;
        //currency
        this.currencyName = credit.getIdCurrency();
    }

    public CreditDTO(CreditDTO creditDto, String currencyName) {
        this(creditDto.getCreditId(), creditDto.getCustomerId(), currencyName, creditDto.getAvailableAmount(), creditDto.getComsumedAmount(),
            creditDto.getLimit(), creditDto.getCreditTypeName(), creditDto.getExpiredDebt(), creditDto.getCreatedAt());
    }
}