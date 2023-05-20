package com.nitesh.splitwise;

import com.nitesh.splitwise.constants.SplitType;
import com.nitesh.splitwise.entity.Expense;
import com.nitesh.splitwise.entity.Group;
import com.nitesh.splitwise.entity.User;
import com.nitesh.splitwise.service.ExpenseManager;
import com.nitesh.splitwise.service.GroupService;
import com.nitesh.splitwise.service.UserService;

import java.util.Arrays;
import java.util.List;

public class SplitWiseApplication {

    public void test1() {
        UserService userService = getUserService();
        GroupService groupService = getGroupService();
        List<User> users = userService.getAllUsers();
        for(User user: users) {
            groupService.addUser("G001", user);
        }
        // print all users
        System.out.println(userService.getAllUsers());
        // print all g
        System.out.println(groupService.getAllUsers("G001"));
        for(User user : users) {
            System.out.println(user.getUserBalanceSheet());
        }

        ExpenseManager expenseManager = new ExpenseManager(groupService);
        System.out.println("Paid by: " + users.get(0) + "Amount: 100");
        Expense expense = new Expense(100, users.get(0),"G001", SplitType.EQUAL);
        expenseManager.addExpenseToGroup(expense);

        for(User user : users) {
            System.out.print(user.getUserId() + ": ");
            System.out.println(user.getUserBalanceSheet());
        }

        System.out.println();
        System.out.println("Paid by: " + users.get(1) + "Amount: 400");
        Expense expense2 = new Expense(400, users.get(1),"G001", SplitType.EQUAL);
        expenseManager.addExpenseToGroup(expense2);

        for(User user : users) {
            System.out.print(user.getUserId() + ": ");
            System.out.println(user.getUserBalanceSheet());
        }

    }

    public static void main(String[] args) {
        SplitWiseApplication app = new SplitWiseApplication();
        app.test1();
    }


    public UserService getUserService() {
        List<User> users =  Arrays.asList(
                new User("U001", "User1"),
                new User("U002", "User2"),
                new User("U003", "User3"),
                new User("U004", "User4")
        );

        UserService userService = new UserService();
        users.forEach(user -> userService.addUser(user));

        return userService;
    }

    public GroupService getGroupService() {
        Group group = new Group("G001", "GName1");
        GroupService groupService = new GroupService();
        groupService.addGroup(group);

        return groupService;
    }
}
