package models;

import constants.SpotType;
import lombok.Data;

import java.util.UUID;

@Data
public class Spot {
    private String spotId;
    private SpotType spotType;
    private boolean available;

    private Spot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.available = true;
    }

    public static Spot from(SpotType spotType) {
        String spotId = "SPT:" + UUID.randomUUID();
        return new Spot(spotId, spotType);
    }
}
