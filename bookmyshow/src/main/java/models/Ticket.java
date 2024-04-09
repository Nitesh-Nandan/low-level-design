package models;

import common.Screen;
import common.Show;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Ticket {
    private String ticketId;
    private Show show;
    private String address;
    private List<Seat> seatList;

    public Ticket(Show show, String address, List<Seat> seatList) {
        this.ticketId = "TKT:" + UUID.randomUUID();
        this.show = show;
        this.address = address;
        this.seatList = seatList;
    }

    public static Ticket generateTicketFrom(Show show, String address, List<Seat> seatList) {
        return new Ticket(show, address, seatList);
    }


}
