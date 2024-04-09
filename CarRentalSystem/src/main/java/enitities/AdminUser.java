package enitities;

import constants.UserRole;

public class AdminUser extends User{
    public AdminUser(String name, Address address) {
        super(name, UserRole.ADMIN, address);
    }
}
