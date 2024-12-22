package CarRental.DAO;

import CarRental.Model.Ride;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RideManager {
   private Map<UUID, Ride> activeRides;

    public RideManager()
    {
        this.activeRides = new HashMap<>();
    }

    public Map<UUID, Ride> getActiveRides() {
        return activeRides;
    }

    public void addOfferRide(Ride ride) throws Exception
    {
        for(Ride r : activeRides.values())
        {
            if(r.getVehicleNumber().equals(ride.getVehicleNumber()))
            {
                throw new Exception("Ride already registered");
            }
        }
        activeRides.put(ride.getId() ,ride);
    }

    public Ride endRide(String vehicleNumber)
    {
        for(Ride r : activeRides.values())
        {
            if(r.getVehicleNumber().equals(vehicleNumber))
            {
                return r;
            }
        }
        return null;
    }

}
