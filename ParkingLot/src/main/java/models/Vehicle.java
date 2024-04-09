package models;

import constants.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private String registrationNumber;
    private VehicleType vehicleType;

    public static Vehicle from (String regNo, VehicleType vehicleType) {
        return new Vehicle(regNo, vehicleType);
    }
}
