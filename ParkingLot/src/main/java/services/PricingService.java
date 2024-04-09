package services;

import models.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

public class PricingService {

    public double calculateBill(Ticket ticket) {
        int hr =  (int) Duration.between(LocalDateTime.now(), ticket.getLoginAt()).getSeconds()/3600;
        return 30 + hr * 20;
    }
}
