package com.nitesh.splitwise.service;

import com.nitesh.splitwise.constants.SplitType;
import com.nitesh.splitwise.entity.Expense;
import com.nitesh.splitwise.entity.Group;
import com.nitesh.splitwise.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupService {
    private final Map<String, Group> groupIdVsGroup = new HashMap<>();

    public void addGroup(Group group) {
        groupIdVsGroup.put(group.getGroupId(), group);
    }

    public void addUser(String groupId, User user) {
        Group group = groupIdVsGroup.getOrDefault(groupId, null);
        if (group == null) {
            throw new RuntimeException("No Group Exists");
        }
        group.addUser(user);
    }

    public List<User> getAllUsers(String groupId) {
        Group group = groupIdVsGroup.getOrDefault(groupId, null);
        if (group == null) {
            throw new RuntimeException("No Group Exists");
        }
        return group.getAllUsers();
    }

    public void addExpense(Expense expense) {
        double amount = expense.getAmount();
        List<User> users = getAllUsers(expense.getGroupId());
        if (users == null || users.isEmpty()) {
            throw new RuntimeException("No Users added this group");
        }

        if (!expense.getSplitType().equals(SplitType.EQUAL)) {
            throw new UnsupportedOperationException("Unsupported operation");
        }
        double splitAmount = amount / users.size();
        for (User user : users) {
            UserService.addExpense(splitAmount, user, expense.getPaidBy());
        }
    }
}
