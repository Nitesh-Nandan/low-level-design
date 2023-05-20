package com.nitesh.splitwise.service;

import com.nitesh.splitwise.entity.Expense;

public class ExpenseManager {

    private final GroupService groupService;

    public ExpenseManager(GroupService groupService) {
        this.groupService = groupService;
    }

    public void addExpenseToGroup(Expense expense) {
        validateForGroupExpense(expense);
        groupService.addExpense(expense);
    }

    public void addExpenseToUser(Expense expense) {
        validateForUserExpense(expense);
        UserService.addExpense(expense.getAmount(), expense.getPaidTo(), expense.getPaidBy());
    }

    public void addExpenseForSplits(Expense expense) {
        validateForSplitExpense(expense);
        // coming soon
    }


    private void validateForGroupExpense(Expense expense) {
        if (expense.getGroupId() == null || expense.getPaidBy() == null) {
            throw new RuntimeException("Invalid Expense");
        }
    }

    private void validateForUserExpense(Expense expense) {
        if (expense.getPaidBy() == null || expense.getPaidTo() == null) {
            throw new RuntimeException("Invalid Expense");
        }
    }

    private void validateForSplitExpense(Expense expense) {
        if (expense.getPaidBy() == null || expense.getPaidTo() == null) {
            throw new RuntimeException("Invalid Expense");
        }
    }
}
