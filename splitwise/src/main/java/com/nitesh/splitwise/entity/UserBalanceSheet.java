package com.nitesh.splitwise.entity;

import java.util.HashMap;
import java.util.Map;

public class UserBalanceSheet {
    private double totalExpense;
    private double amountToRecover;
    private final Map<String, Splits> friendsVsSplits;

    public UserBalanceSheet() {
        this.totalExpense = 0;
        this.amountToRecover = 0;
        this.friendsVsSplits = new HashMap<>();
    }

    public void addInExpense(double amount) {
        this.totalExpense += amount;
    }

    public void addInRecover(double amount) {
        this.amountToRecover += amount;
    }

    public void addSplits(String userId, Splits splits) {
        Splits existing = friendsVsSplits.getOrDefault(userId, null);
        if (existing == null) {
            friendsVsSplits.put(userId, splits);
        } else {
            if (!splits.getCreditType().equals(existing.getCreditType())) {
                if (splits.getAmount() >= existing.getAmount()) {
                    double diff = splits.getAmount() - existing.getAmount();
                    friendsVsSplits.put(userId, new Splits(userId, diff, splits.getCreditType()));
                } else {
                    double diff = existing.getAmount() - splits.getAmount();
                    friendsVsSplits.put(userId, new Splits(userId, diff, existing.getCreditType()));
                }
            } else {
                double total = splits.getAmount() + existing.getAmount();
                friendsVsSplits.put(userId, new Splits(userId, total, existing.getCreditType()));
            }
        }
    }

    @Override
    public String toString() {
        return "UserBalanceSheet{" +
                "totalExpense=" + totalExpense +
                ", amountToRecover=" + amountToRecover +
                ", friendsVsSplits=" + friendsVsSplits +
                '}';
    }
}
