package com.project1.credit.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "credit")
public class Credit {
    @Id
    private String idCredit;
    private Double availableAmount;
    private Double consumedAmount;
    private CreditType creditType;
    private List<CreditTrasaction> creditTrasactions;

    public Credit() {
    }

    public Credit(String idCredit, Double availableAmount, Double consumedAmount, CreditType creditType, List<CreditTrasaction> creditTrasactions) {
        this.idCredit = idCredit;
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
            ", availableAmount='" + getAvailableAmount() + "'" +
            ", consumedAmount='" + getConsumedAmount() + "'" +
            ", creditType='" + getCreditType() + "'" +
            ", creditTrasactions='" + getCreditTrasactions() + "'" +
            "}";
    }
}