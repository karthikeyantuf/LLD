package ParkingLot.Vehicle;

import ParkingLot.Parking.ParkingTicket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Vehicle {
    private String vehicleNumber;
    private String licenseNumber;
    private VehicleType type;
    private ParkingTicket parkingTicket;

    public Vehicle(String vehicleNumber,VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.type = vehicleType;
    }
}
