package com.nitesh.splitwise.entity;

import com.nitesh.splitwise.constants.CreditType;

public class User {
    private final String userId;
    private final String userName;
    private final UserBalanceSheet userBalanceSheet;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.userBalanceSheet = new UserBalanceSheet();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public UserBalanceSheet getUserBalanceSheet() {
        return userBalanceSheet;
    }
}
