package MovieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class Hall {
    private String id;
    private String name;
    private List<Seat> seatList;
    private List<Show> showList;

    public Hall(String name)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.seatList = new ArrayList<>();
        this.showList = new ArrayList<>();
        intializeSeat();
    }

    public void addSeat(Seat seat)
    {
        seatList.add(seat);
    }

    public void intializeSeat()
    {

        IntStream.rangeClosed(0,6).forEach(i ->{
            Seat seat = new Seat(SeatType.NORMAL,i);
            addSeat(seat);
        });

        IntStream.rangeClosed(6,11).forEach(i ->{
            Seat seat = new Seat(SeatType.LUXURY,i);
            addSeat(seat);
        });


    }

    public void addShow(Show show)
    {
        showList.add(show);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public List<Show> getShowList() {
        return showList;
    }
}

