package enitities;

import constants.UserRole;

public class Driver extends User {

    private DrivingLicence drivingLicence;
    public Driver(String name, Address address) {
        super(name, UserRole.DRIVER, address);
    }

    public static class DrivingLicence {
        
    }
}
