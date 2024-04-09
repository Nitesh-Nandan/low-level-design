package services;

import constants.SpotType;
import models.Spot;
import models.Ticket;
import models.Vehicle;

public class BookingManager {
    private final SpotManager spotManager;
    private final PricingService pricingService;

    private final PaymentService paymentService;

    public BookingManager(SpotManager spotManager, PricingService pricingService,
                          PaymentService paymentService) {
        this.spotManager = spotManager;
        this.pricingService = pricingService;
        this.paymentService = paymentService;
    }

    public Ticket bookTicket(Vehicle vehicle) {
        Spot spot = spotManager.findAvailableSpot(getSpotType(vehicle));
        if (spot == null) {
            return null;
        }
        if (spotManager.markSpotBooked(spot)) {
            return new Ticket(vehicle, spot);
        }
        throw new RuntimeException("Exception in Booking try again");
    }

    public double getBill(Ticket ticket) {
        return pricingService.calculateBill(ticket);
    }


    public String checkout(Ticket ticket) {
        ticket.setExitedAt(ticket.getExitedAt());
        spotManager.markSpotFree(ticket.getSpot());
        double amount = getBill(ticket);
        return paymentService.makePayment(ticket, amount);
    }

    private SpotType getSpotType(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case CAR:
                return SpotType.CAR;
            case BIKE:
                return SpotType.BIKE;
            case TRUCK:
                return SpotType.TRUCK;
            case ELECTRIC:
                return SpotType.ELECTRIC;
            default:
                return SpotType.OTHERS;
        }
    }
}
