import constants.SpotType;
import constants.VehicleType;
import models.Ticket;
import services.*;

public class MyParking {
    private final SpotManager spotManager = new SpotManager();
    private final PricingService pricingService = new PricingService();
    private final PaymentService paymentService = new PaymentService();
    private BookingManager bookingManager = new BookingManager(spotManager, pricingService, paymentService);
    private UserService userService = new UserService(bookingManager);
    private AdminService adminService = new AdminService(spotManager);

    private  void addSpots() {
        System.out.println(adminService.addSpot(SpotType.BIKE));
        System.out.println(adminService.addSpot(SpotType.CAR));
        System.out.println(adminService.addSpot(SpotType.TRUCK));
        System.out.println(adminService.addSpot(SpotType.CAR));
        System.out.println(adminService.addSpot(SpotType.TRUCK));
    }

    private Ticket bookTicket(VehicleType vehicleType, String regNo) {
        return userService.bookTicket(vehicleType, regNo);
    }

    private void chekcout(Ticket ticket) {
         userService.checkout(ticket);
    }

    public static void main(String[] args) {
        MyParking parking = new MyParking();
        parking.addSpots();

        Ticket t1 = parking.bookTicket(VehicleType.BIKE, "BK01");
        System.out.println(t1);
        parking.chekcout(t1);
        System.out.println(parking.bookTicket(VehicleType.BIKE, "BK02"));

    }

}
