package MovieBooking;

import java.util.Arrays;

public class Client {
    public static void main(String args[])
    {
        MoviebookingDao dao = new MoviebookingDao();
        dao.addUser("Karthik");
        City city = dao.addCity("Dublin");
        Cinema cinema = dao.addCinema("PSS", city.getId());
        Hall hall = dao.addHall("HONE" , cinema.getId());
        Movie movie = new Movie("NTK","Comedy","Tamil");
        Show show = dao.addShow(Showname.AFTERNOON,movie, hall.getId());

        dao.doBooking(show,Arrays.asList(1,3),PaymentType.UPI,200.00,hall.getId());

        dao.getAvailableSeatsForShow(hall,show);

    }
}
