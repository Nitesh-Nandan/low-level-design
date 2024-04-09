package services;

import constants.SpotType;
import models.Spot;

import java.util.*;

public class SpotManager {
    private Map<String, List<Spot>> spotsMap = new HashMap<>();

    public Spot findAvailableSpot(SpotType spotType) {
        Optional<Spot> optionalSpot = spotsMap.get(spotType.name()).stream()
                .filter(Spot::isAvailable)
                .findAny();

        return optionalSpot.orElse(null);
    }

    public boolean markSpotBooked(Spot spot) {
        if (!spot.isAvailable()) {
            return false;
        }
        synchronized (spot) {
            if (spot.isAvailable()) {
                spot.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean markSpotFree(Spot spot) {
        spot.setAvailable(true);
        return true;
    }

    public void addSpot(Spot spot) {
        spotsMap.putIfAbsent(spot.getSpotType().name(), new ArrayList<>());
        spotsMap.get(spot.getSpotType().name()).add(spot);
    }
}
