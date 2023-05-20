package com.nitesh.splitwise.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Group {
    private final String groupId;
    private final String groupName;
    private final List<User> users;

    public Group(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = new ArrayList<>();
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", users=" + users +
                '}';
    }
}
