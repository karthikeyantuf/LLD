package CarRental.Model;

import CarRental.DAO.RideManager;

public interface SelectionStrategy {
    public Ride findRide(String origin, String destination, int seats, RideManager rideManager, String vehicleModel);
}
