package CarRental.Model;

import CarRental.DAO.RideManager;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PreferredSelectionStrategy implements SelectionStrategy{
    @Override
    public Ride findRide(String origin, String destination, int seats, RideManager rideManager, String vehicleModel) {
        Map<UUID,Ride> rides = rideManager.getActiveRides();

        for(Ride r : rides.values())
        {
            if(r.getOrigin().equals(origin) && r.getDestination().equals(destination) && r.getAvailableSeats() >= seats)
            {
                if(r.getVehicleModel().equals(vehicleModel))
                {
                    return r;
                }
            }
        }
        return null;
    }
}
