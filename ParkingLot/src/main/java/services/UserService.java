package services;

import constants.VehicleType;
import models.Ticket;
import models.Vehicle;

public class UserService {
    private final BookingManager bookingManager;

    public UserService(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    public Ticket bookTicket(VehicleType vehicleType, String regNo) {
        Vehicle vehicle = Vehicle.from(regNo, vehicleType);
        return bookingManager.bookTicket(vehicle);
    }

    public double getMyFare(Ticket ticket) {
        return bookingManager.getBill(ticket);
    }

    public boolean checkout(Ticket ticket) {
        String paymentId = bookingManager.checkout(ticket);
        System.out.println("Payment done: " + paymentId);
        return true;
    }
}
