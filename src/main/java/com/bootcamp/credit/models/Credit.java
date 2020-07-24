package com.bootcamp.credit.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit")
public class Credit {
    @Id
    private String idCredit;
    private String idCustomer;
    private String idCurrency;
    private Double availableAmount;
    private Double consumedAmount;
    private String creditType;
    @Nullable
    private Double limit;
    private int expiredDebt;
    @Nullable
    private List<String> creditTransactions;
    private String bankId;

    public Credit(String idCredit) {
        this.idCredit = idCredit;
    }
}