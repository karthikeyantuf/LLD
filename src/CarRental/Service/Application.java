package CarRental.Service;

import CarRental.DAO.RideManager;
import CarRental.DAO.UserManager;
import CarRental.Model.*;

import java.util.List;

public class Application {
    RideManager rideManager;
    UserManager userManager;

    public Application()
    {
        this.rideManager = new RideManager();
        this.userManager = new UserManager();
    }

    public void add_user(String name , Character gender, int age)  {
        User user = new User(name,gender,age);
        try {
            userManager.addUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void add_vehicle(String userName,String vehicleModel,String vehicleNumber)
    {
        Vehicle vehicle = new Vehicle(userName,vehicleModel,vehicleNumber);
        User user = userManager.getUser(userName);
        user.addVehicle(vehicle);
    }

    public void offer_ride(String userName,String origin,int seats,String vehicleModel,String vehicleNumber,String destination)
    {
        Ride newRide = new Ride(userName,origin,destination,vehicleModel,vehicleNumber,seats);
        User user = userManager.getUser(userName);
        user.addSharedRide(newRide);
    }

    public void select_ride(String userName,String origin, String destination, int seats, SelectionStrategyType selectionStrategyType,String vehicleModel)
    {
        SelectionStrategy strategy = null;

        if(selectionStrategyType.equals(SelectionStrategyType.PREFERRED))
        {
            strategy = new PreferredSelectionStrategy();
        }
        else if(selectionStrategyType.equals(SelectionStrategyType.MOST_VACANT))
        {
            strategy = new MostVacantSelectionStrategy();
        }

       Ride ride =  strategy.findRide(origin,destination,seats,rideManager,vehicleModel);

        if(ride!=null)
        {
            ride.addPassenger(userName, seats);
        }
    }

    public void end_ride(String vehicleNumber)
    {
        Ride ride = rideManager.endRide(vehicleNumber);
        ride.endRide();
        String sharedBy = ride.getSharedBy();
        List<String> passengers = ride.getSelectedBy();

        userManager.getUser(sharedBy).addSharedRide(ride);

        for(String passenger : passengers)
        {
            User user = userManager.getUser(passenger);
            user.addConsumedRide(ride);
        }
    }
}
