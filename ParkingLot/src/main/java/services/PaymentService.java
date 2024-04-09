package services;

import models.Ticket;

import java.util.UUID;

public class PaymentService {
    String makePayment(Ticket ticket, double amount) {
        System.out.println("Payment done for ticket " + ticket.getTicketId() + " amount paid " + amount);
        return "PYNT" + UUID.randomUUID();
    }
}
