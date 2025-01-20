package ParkingLot.Parking;

import java.util.HashMap;
import java.util.Map;

public class HourlyCost {
    private Map<ParkingSpotType, Double> hourlyCosts = new HashMap<>();

    public HourlyCost() {
        hourlyCosts.put(ParkingSpotType.CAR, 20.0);
        hourlyCosts.put(ParkingSpotType.ELECTRIC, 25.0);
        hourlyCosts.put(ParkingSpotType.BIKE, 10.0);
    }

    public double getCost(ParkingSpotType parkingSpotType) {
        return hourlyCosts.get(parkingSpotType);
    }
}
