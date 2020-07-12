package com.project1.credit.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

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
    @Nullable
    private List<String> creditTransactions;

    public Credit() {
    }

    public Credit(String idCredit, String idCustomer, String idCurrency, Double availableAmount, Double consumedAmount, String creditType, Double limit, List<String> creditTransactions) {
        this.idCredit = idCredit;
        this.idCustomer = idCustomer;
        this.idCurrency = idCurrency;
        this.availableAmount = availableAmount;
        this.consumedAmount = consumedAmount;
        this.creditType = creditType;
        this.limit = limit;
        this.creditTransactions = creditTransactions;
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

    public String getIdCurrency() {
        return this.idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
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

    public String getCreditType() {
        return this.creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public Double getLimit() {
        return this.limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public List<String> getCreditTransactions() {
        return this.creditTransactions;
    }

    public void setCreditTransactions(List<String> creditTransactions) {
        this.creditTransactions = creditTransactions;
    }

    @Override
    public String toString() {
        return "{" +
            " idCredit='" + getIdCredit() + "'" +
            ", idCustomer='" + getIdCustomer() + "'" +
            ", idCurrency='" + getIdCurrency() + "'" +
            ", availableAmount='" + getAvailableAmount() + "'" +
            ", consumedAmount='" + getConsumedAmount() + "'" +
            ", creditType='" + getCreditType() + "'" +
            ", limit='" + getLimit() + "'" +
            ", creditTransactions='" + getCreditTransactions() + "'" +
            "}";
    }
}