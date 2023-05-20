package com.nitesh.splitwise.entity;

import com.nitesh.splitwise.constants.SplitType;

import java.util.List;

public class Expense {
    private final double amount;
    private final User paidTo;
    private final User paidBy;
    private String groupId;
    private SplitType splitType;
    private List<Splits> splits;

    public Expense(double amount, User paidBy, User paidTo) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.paidTo = paidTo;
        this.groupId = null;
        this.splitType = null;
    }

    public Expense(double amount, User paidBy, String groupId, SplitType splitType) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.groupId = groupId;
        this.splitType = splitType;
        this.paidTo = null;
    }

    public Expense(double amount, User paidBy, List<Splits> splits) {
        if (splits == null || splits.isEmpty()) {
            throw new RuntimeException("InvalidExpense");
        }
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.paidTo = null;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public String getGroupId() {
        return groupId;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Splits> getSplits() {
        return splits;
    }

    public User getPaidTo() {
        return paidTo;
    }
}
