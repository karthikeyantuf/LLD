package MovieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class City {
   private String id;
   private String name;
   private List<Cinema> cinemaList;

    public City(String name)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        cinemaList = new ArrayList<>();
    }

    public void addCinema(Cinema cinema)
    {
        cinemaList.add(cinema);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }
}
