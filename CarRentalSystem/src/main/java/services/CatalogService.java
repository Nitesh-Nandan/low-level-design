package services;

import enitities.Driver;
import enitities.Vehicle;
import models.DriverSearchFilter;
import models.VehicleSearchFilter;

import java.util.List;

public interface CatalogService {

    List<Vehicle> searchVehicles(VehicleSearchFilter filter);

    List<Driver> searchDriver(DriverSearchFilter filter);
}
