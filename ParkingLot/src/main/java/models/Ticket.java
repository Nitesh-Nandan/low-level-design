package models;

import constants.SpotType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private Spot spot;
    private LocalDateTime loginAt;
    private LocalDateTime exitedAt;

    public Ticket(Vehicle vehicle, Spot spot) {
        this.ticketId = "TKT:" + UUID.randomUUID();
        this.vehicle = vehicle;
        this.spot = spot;
        this.loginAt = LocalDateTime.now();
    }
}
