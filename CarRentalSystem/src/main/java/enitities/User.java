package enitities;

import constants.UserRole;

import java.util.UUID;

public abstract class User {
    private String userId;
    private String name;
    private UserRole role;
    private Address address;

    public User(String name, UserRole role, Address address) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.role = role;
        this.address = address;
    }

    public static class Address {

    }
}
