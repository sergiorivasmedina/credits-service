package com.bootcamp.credit.models;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date createdAt;

    public Credit(String idCredit) {
        this.idCredit = idCredit;
    }
}