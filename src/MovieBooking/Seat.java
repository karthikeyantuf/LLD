package MovieBooking;

import java.util.UUID;

public class Seat {
    private String id;
    private int seatNumber;
    private SeatType type;

    public Seat(SeatType type,int seatNumber)
    {
        this.id = UUID.randomUUID().toString();
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public SeatType getType() {
        return type;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
