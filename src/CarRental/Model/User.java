package CarRental.Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private Character gender;
    private int age;
    private List<Vehicle> vehicles;
    private List<Ride> consumedRides;
    private List<Ride> sharedRides;

    public User(String name,Character gender,int age)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        vehicles = new ArrayList<>();
        consumedRides = new ArrayList<>();
        sharedRides = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addVehicle(Vehicle vehicle)
    {
        if(vehicles.contains(vehicle))
        {
            throw new RuntimeException("Vehicle already registered");
        }
        vehicles.add(vehicle);
    }

    public void addSharedRide(Ride ride)
    {
        this.sharedRides.add(ride);
    }

    public void addConsumedRide(Ride ride)
    {
        this.consumedRides.add(ride);
    }
}
