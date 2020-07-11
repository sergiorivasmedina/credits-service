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
    private Double availableAmount;
    private Double consumedAmount;
    private String creditType;
    @Nullable
    private List<String> creditTrasactions;

    public Credit() {
    }

    public Credit(String idCredit, String idCustomer, Double availableAmount, Double consumedAmount, String creditType, List<String> creditTrasactions) {
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

    public String getCreditType() {
        return this.creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public List<String> getCreditTrasactions() {
        return this.creditTrasactions;
    }

    public void setCreditTrasactions(List<String> creditTrasactions) {
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