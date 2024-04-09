package services;

import constants.SpotType;
import models.Spot;

public class AdminService {
    private final SpotManager spotManager;

    public AdminService(SpotManager spotManager) {
        this.spotManager = spotManager;
    }

    public Spot addSpot(SpotType spotType) {
        Spot spot = Spot.from(spotType);
        spotManager.addSpot(spot);
        return spot;
    }

    public Spot deleteSpot(Spot spot) {
        //
        return null;
    }

    public Spot deleteSpotById(String id) {
        //
        return null;
    }

}
