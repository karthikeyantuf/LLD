package MovieBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cinema {
    private String id;
    private String name;
    List<Hall> hallList;

    public Cinema(String name)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.hallList = new ArrayList<>();
    }

    public void addHall(Hall hall)
    {
        hallList.add(hall);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Hall> getHallList() {
        return hallList;
    }
}
