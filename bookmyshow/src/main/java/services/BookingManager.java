package services;

import common.Show;
import constants.SeatStatus;
import models.Multiplex;
import models.Seat;
import models.Ticket;

import java.util.List;
import java.util.Map;

public class BookingManager {
    private Map<String, Show> showList;
    private MultiplexRepository multiplexService;


    public Ticket bookShows(String showId, String multiplexId,  List<Seat> seatList) {
        markSeatsReserved(seatList);
        Multiplex multiplex = multiplexService.getMultiplexById(multiplexId);
        Ticket ticket = Ticket.generateTicketFrom(showList.get(showId), multiplex.getAddress(), seatList);
        try {
            // make payment
        } catch (Exception ex) {
            // rollback
        }
        return ticket;
    }

    private synchronized void markSeatsReserved(List<Seat> seatList) {
        for(Seat seat : seatList) {
            if(seat.getSeatStatus() != SeatStatus.AVAILABLE) {
                throw new RuntimeException("Seats are booked");
            }
            seat.setSeatStatus(SeatStatus.IN_PROGRESS);
        }
    }

    private boolean makePayment(Ticket ticket) {
        return true;
    }



}
