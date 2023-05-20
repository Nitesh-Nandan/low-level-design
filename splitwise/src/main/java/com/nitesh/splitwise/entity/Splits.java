package com.nitesh.splitwise.entity;

import com.nitesh.splitwise.constants.CreditType;

public class Splits {
    private double amount;
    private String userId;
    private CreditType creditType;

    public Splits(String userId, double amount, CreditType creditType) {
        this.userId = userId;
        this.amount = amount;
        this.creditType = creditType;
    }

    public double getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }

    public CreditType getCreditType() {
        return creditType;
    }

    @Override
    public String toString() {
        return "Splits{" +
                "amount=" + amount +
                ", userId='" + userId + '\'' +
                ", creditType=" + creditType +
                '}';
    }
}
