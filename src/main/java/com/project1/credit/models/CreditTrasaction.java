package com.project1.credit.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditTransaction")
public class CreditTrasaction {
    @Id
    private String idCreditTransaction;
    private Double amount;
    private Date creationDate;
    private TransactionType transactionType;

    public CreditTrasaction() {
    }

    public CreditTrasaction(String idCreditTransaction, Double amount, Date creationDate, TransactionType transactionType) {
        this.idCreditTransaction = idCreditTransaction;
        this.amount = amount;
        this.creationDate = creationDate;
        this.transactionType = transactionType;
    }

    public String getIdCreditTransaction() {
        return this.idCreditTransaction;
    }

    public void setIdCreditTransaction(String idCreditTransaction) {
        this.idCreditTransaction = idCreditTransaction;
    }

    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "{" +
            " idCreditTransaction='" + getIdCreditTransaction() + "'" +
            ", amount='" + getAmount() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", transactionType='" + getTransactionType() + "'" +
            "}";
    }
}