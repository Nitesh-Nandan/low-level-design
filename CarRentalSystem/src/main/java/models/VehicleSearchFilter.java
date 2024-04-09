package models;

import lombok.Builder;

@Builder
public class VehicleSearchFilter {
    private String vehicleType;

    private Integer capacity;

    private String availableStatus;
}
