package CarRental.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ride {
    private UUID id;
    private String sharedBy;
    private String origin;
    private String destination;
    private RideStatus status;
    private String vehicleNumber;
    private String vehicleModel;
    private int availableSeats;
    private List<String> selectedBy;

    public Ride(String sharedBy,String origin,String destination,String vehicleModel,String vehicleNumber,int availableSeats)
    {
        this.id = UUID.randomUUID();
        this.sharedBy = sharedBy;
        this.origin = origin;
        this.availableSeats = availableSeats;
        this.destination = destination;
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        selectedBy = new ArrayList<>();
        this.status = RideStatus.ACTIVE;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(String sharedBy) {
        this.sharedBy = sharedBy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<String> getSelectedBy() {
        return selectedBy;
    }

    public void setSelectedBy(List<String> selectedBy) {
        this.selectedBy = selectedBy;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void endRide()
    {
        this.status = RideStatus.END;
    }

    public void addPassenger(String sharedBy,int seats)
    {
        this.selectedBy.add(sharedBy);
        this.availableSeats -= seats;
    }
}
