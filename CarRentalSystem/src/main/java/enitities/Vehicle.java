package enitities;

import constants.VehicleBookingStatus;
import constants.VehicleType;
import lombok.Data;
import sun.dc.pr.PRError;

@Data
public class Vehicle {

    private String vehicleId;
    private VehicleType vehicleType;
    private VehicleInfo vehicleInfo;
    private VehicleBookingStatus bookingStatus;

    public Vehicle(VehicleType vehicleType, VehicleInfo vehicleInfo) {
        this.vehicleType = vehicleType;
        this.vehicleInfo = vehicleInfo;
    }

    public static class VehicleInfo {
        public String registrationNumber;
        public String model;
        public double fuelCapacity;
    }
}
