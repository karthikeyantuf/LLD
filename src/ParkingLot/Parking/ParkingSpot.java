package ParkingLot.Parking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingSpot {
    private String parkingSpotId;
    private boolean isFree;
    private String assignedVehicleId;
    private ParkingSpotType parkingSpotType;

    public ParkingSpot(String parkingSpotId,ParkingSpotType parkingSpotType)
    {
        this.parkingSpotId = parkingSpotId;
        this.parkingSpotType = parkingSpotType;
    }

    public void assignVehicleToParkingSpot(String vehicleId)
    {
        this.assignedVehicleId = vehicleId;
    }

    public void freeSpot()
    {
        this.isFree = true;
        this.assignedVehicleId = null;
    }
}
