package com.project1.credit.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

@Document(collection = "credit")
public class Credit {
    @Id
    private String idCredit;

    private String idCustomer;

    private Double availableAmount;

    private Double consumedAmount;
    
    @DBRef
    private CreditType creditType;

    @Nullable
    @DBRef
    private List<CreditTrasaction> creditTrasactions;

    public Credit() {
    }

    public Credit(String idCredit, String idCustomer, Double availableAmount, Double consumedAmount, CreditType creditType, List<CreditTrasaction> creditTrasactions) {
        this.idCredit = idCredit;
        this.idCustomer = idCustomer;
        this.availableAmount = availableAmount;
        this.consumedAmount = consumedAmount;
        this.creditType = creditType;
        this.creditTrasactions = creditTrasactions;
    }

    public String getIdCredit() {
        return this.idCredit;
    }

    public void setIdCredit(String idCredit) {
        this.idCredit = idCredit;
    }

    public String getIdCustomer() {
        return this.idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Double getAvailableAmount() {
        return this.availableAmount;
    }

    public void setAvailableAmount(Double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public Double getConsumedAmount() {
        return this.consumedAmount;
    }

    public void setConsumedAmount(Double consumedAmount) {
        this.consumedAmount = consumedAmount;
    }

    public CreditType getCreditType() {
        return this.creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    public List<CreditTrasaction> getCreditTrasactions() {
        return this.creditTrasactions;
    }

    public void setCreditTrasactions(List<CreditTrasaction> creditTrasactions) {
        this.creditTrasactions = creditTrasactions;
    }

    @Override
    public String toString() {
        return "{" +
            " idCredit='" + getIdCredit() + "'" +
            ", idCustomer='" + getIdCustomer() + "'" +
            ", availableAmount='" + getAvailableAmount() + "'" +
            ", consumedAmount='" + getConsumedAmount() + "'" +
            ", creditType='" + getCreditType() + "'" +
            ", creditTrasactions='" + getCreditTrasactions() + "'" +
            "}";
    }

}