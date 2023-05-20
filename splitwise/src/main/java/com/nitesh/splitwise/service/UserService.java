package com.nitesh.splitwise.service;

import com.nitesh.splitwise.constants.CreditType;
import com.nitesh.splitwise.entity.Splits;
import com.nitesh.splitwise.entity.User;
import com.nitesh.splitwise.entity.UserBalanceSheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private final Map<String, User> userIdVsUser = new HashMap<>();

    public void addUser(User user) {
        userIdVsUser.put(user.getUserId(), user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userIdVsUser.values());
    }

    public User getUser(String userId) {
        User user = userIdVsUser.getOrDefault(userId, null);
        if (user == null) {
            user = new User(userId, userId.concat(":").concat(String.valueOf(System.currentTimeMillis())));
            userIdVsUser.put(userId, user);
        }
        return user;
    }

    public static void addExpense(double amount, User paidTo, User paidBy) {
        if (paidTo.getUserId().equals(paidBy.getUserId())) {
            UserBalanceSheet balanceSheet = paidBy.getUserBalanceSheet();
            balanceSheet.addInExpense(amount);
        } else {
            UserBalanceSheet paidToUserBalanceSheet = paidTo.getUserBalanceSheet();
            UserBalanceSheet paidByUserBalanceSheet = paidBy.getUserBalanceSheet();
            Splits splitsForPaidToUser = new Splits(paidBy.getUserId(), amount, CreditType.OWE);
            Splits splitsForPaidByUser = new Splits(paidTo.getUserId(), amount, CreditType.LENT);

            paidToUserBalanceSheet.addInExpense(amount);
            paidToUserBalanceSheet.addSplits(paidBy.getUserId(), splitsForPaidToUser);

            paidByUserBalanceSheet.addInRecover(amount);
            paidByUserBalanceSheet.addSplits(paidTo.getUserId(), splitsForPaidByUser);
        }
    }
}
