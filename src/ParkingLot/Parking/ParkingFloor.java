package ParkingLot.Parking;

import ParkingLot.Vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

@Setter
@Getter
public class ParkingFloor {
    private String floorId;
    private Map<ParkingSpotType, Deque<ParkingSpot>> parkingSpots = new HashMap<>();
    private Map<String,ParkingSpot> usedParkingSpots = new HashMap<>();

    public ParkingFloor(String floorId)
    {
        this.floorId = floorId;
        parkingSpots.put(ParkingSpotType.CAR,new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.BIKE,new ConcurrentLinkedDeque<>());
        parkingSpots.put(ParkingSpotType.ELECTRIC,new ConcurrentLinkedDeque<>());
    }

    public boolean isFloorFull()
    {
        for(Map.Entry<ParkingSpotType,Deque<ParkingSpot>> entry : parkingSpots.entrySet())
        {
            if(entry.getValue().size() > 0)
            {
                return true;
            }
        }

        return false;
    }

    public static ParkingSpotType getParkingSpotType(VehicleType vehicleType)
    {
        switch(vehicleType)
        {
            case CAR :
                return ParkingSpotType.CAR;
            case BIKE:
                return ParkingSpotType.BIKE;
            case ELECTRIC:
                return ParkingSpotType.ELECTRIC;
            default:
                return null;
        }
    }

    public boolean canPark(VehicleType vehicleType)
    {
        return canPark(getParkingSpotType(vehicleType));
    }

    public boolean canPark(ParkingSpotType parkingSpotType)
    {
        return parkingSpots.get(parkingSpotType).size() > 0;
    }

    public ParkingSpot vacateParkingSpot(String parkingSpotId)
    {
        ParkingSpot parkingSpot = usedParkingSpots.remove(parkingSpotId);
        if(parkingSpot != null)
        {
            parkingSpot.freeSpot();
            parkingSpots.get(parkingSpot.getParkingSpotType()).addFirst(parkingSpot);
            return parkingSpot;
        }
        return null;
    }

    public synchronized ParkingSpot getSpot(VehicleType vehicleType)
    {
        if(!canPark(vehicleType)) return  null;
        ParkingSpot parkingSpot = parkingSpots.get(getParkingSpotType(vehicleType)).poll();
        usedParkingSpots.put(parkingSpot.getParkingSpotId(), parkingSpot);
        return parkingSpot;
    }
}
