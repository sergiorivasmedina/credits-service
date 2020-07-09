package com.project1.credit.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditType")
public class CreditType {
    @Id
    private String idCreditType;
    private String name;

    public CreditType() {
    }

    public CreditType(String idCreditType, String name) {
        this.idCreditType = idCreditType;
        this.name = name;
    }

    public String getIdCreditType() {
        return this.idCreditType;
    }

    public void setIdCreditType(String idCreditType) {
        this.idCreditType = idCreditType;
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
            " idCreditType='" + getIdCreditType() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}