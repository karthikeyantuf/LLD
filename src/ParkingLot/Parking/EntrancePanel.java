package ParkingLot.Parking;

import ParkingLot.Vehicle.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class EntrancePanel {
    private String id;

    public EntrancePanel(String id) {
        this.id = id;
    }

    public ParkingTicket getParkingTicket(Vehicle vehicle) {
        if (!ParkingLot.INSTANCE.canPark(vehicle.getType()))
            return null;
        ParkingSpot parkingSpot = ParkingLot.INSTANCE.getParkingSpot(vehicle.getType());
        if (parkingSpot == null)
            return null;
        return buildTicket(vehicle.getLicenseNumber(), parkingSpot.getParkingSpotId());
    }

    private ParkingTicket buildTicket(String vehicleLicenseNumber, String parkingSpotId) {
        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setIssuedAt(LocalDateTime.now());
        parkingTicket.setAllocatedSpotId(parkingSpotId);
        parkingTicket.setLicensePlateNumber(vehicleLicenseNumber);
        parkingTicket.setTicketNumber(UUID.randomUUID().toString());
        parkingTicket.setTicketStatus(TicketStatus.ACTIVE);
        return parkingTicket;
    }
}
