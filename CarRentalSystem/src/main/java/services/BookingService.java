package services;

import enitities.BookingInvoice;
import enitities.User;
import enitities.Vehicle;
import models.BookingTimings;

public interface BookingService {

    BookingInvoice bookVehicle(Vehicle vehicle, BookingTimings timings, User user);

    BookingInvoice bookVehicle(Vehicle vehicle, BookingTimings timings, User customer, User driver);
}
