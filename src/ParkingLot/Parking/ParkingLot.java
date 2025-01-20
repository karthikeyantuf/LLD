package ParkingLot.Parking;

import ParkingLot.Vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class ParkingLot {
    private String parkingLotId;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private List<EntrancePanel> entrancePanels;
    private List<ExitPanel> exitPanels;

    public static ParkingLot INSTANCE  = new ParkingLot();

    private ParkingLot()
    {
        this.parkingLotId = UUID.randomUUID().toString();
        this.entrancePanels = new ArrayList<>();
        this.exitPanels = new ArrayList<>();
        this.parkingFloors = new ArrayList<>();
    }

    public boolean isFull()
    {
        for(ParkingFloor floor : parkingFloors)
        {
            if(!floor.isFloorFull())
            {
                return false;
            }
        }
        return true;
    }

    public boolean canPark(VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.canPark(ParkingFloor.getParkingSpotType(vehicleType)))
                return true;
        }
        return false;
    }

    public ParkingSpot getParkingSpot(VehicleType vehicleType) {
        for (ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
            ParkingSpot parkingSpot = parkingFloor.getSpot(vehicleType);
            if (parkingSpot != null) {
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId) {
        for (ParkingFloor parkingFloor : ParkingLot.INSTANCE.getParkingFloors()) {
            ParkingSpot parkingSpot = parkingFloor.vacateParkingSpot(parkingSpotId);
            if (parkingSpot != null)
                return parkingSpot;
        }
        return null;
    }
}
