package CarRental.Model;

import CarRental.DAO.RideManager;

import java.util.Map;
import java.util.UUID;

public class MostVacantSelectionStrategy implements SelectionStrategy{
    @Override
    public Ride findRide(String origin, String destination, int seats, RideManager rideManager, String vehicleModel) {
        int maxAvailability = 0;
        Ride potentialRide = null;
        Map<UUID, Ride> activeRides= rideManager.getActiveRides();
        for(Ride r : activeRides.values())
        {
            if(r.getOrigin().equals(origin) && r.getDestination().equals(destination) && r.getAvailableSeats() >= seats)
            {
                if(maxAvailability < r.getAvailableSeats())
                {
                    potentialRide = r;
                }
            }
        }
        return potentialRide;
    }
}
