package models;

import constants.SeatStatus;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Seat {
    private String seatId;
    private double price;
    private SeatStatus seatStatus;

    private Seat(double price){
        this.seatId = "ST:" +  UUID.randomUUID();
        this.price = price;
        seatStatus = SeatStatus.AVAILABLE;
    }
    public static Seat from(double price) {
        return new Seat(price);
    }
}
