package com.project1.credit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactionType")
public class TransactionType {
    @Id
    private String idTransactioType;
    private String name;

    public TransactionType() {
    }

    public TransactionType(String idTransactioType, String name) {
        this.idTransactioType = idTransactioType;
        this.name = name;
    }

    public String getIdTransactioType() {
        return this.idTransactioType;
    }

    public void setIdTransactioType(String idTransactioType) {
        this.idTransactioType = idTransactioType;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " idTransactioType='" + getIdTransactioType() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}