package MovieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking {
   private String id;
   private Show showId;
   private List<Seat> selectedSeats;
   private PaymentType type;
   private Double amount;

    public Booking(String showId,PaymentType type,Double amount)
    {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.type = type;
        this.selectedSeats = new ArrayList<>();
    }

    public void addSelectedSeats(List<Seat> seats)
    {
        this.selectedSeats = new ArrayList<>(seats);
    }

}
