package MovieBooking;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Show {
    private String id;
    Showname name;
    Movie movie;
    private HashSet<Seat> bookedSeats;

    public Show(Showname name,Movie movie)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.bookedSeats = new HashSet<>();
        this.movie = movie;
    }

    public HashSet<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public String getId() {
        return id;
    }

    public void addBookedSeats(List<Seat> seats)
    {
        for(Seat seat : seats)
        {
            bookedSeats.add(seat);
        }

    }
}
