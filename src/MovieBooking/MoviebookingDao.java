package MovieBooking;

import java.util.*;
import java.util.stream.Collectors;

public class MoviebookingDao {
    private HashMap<String , List<Booking>> userVsBooking;
    private HashMap<String , Cinema> cinemaIdVsCinema;
    private HashMap<String , Show> showIdVsShow;
    private HashMap<String , City> cityIdVsCity;
    private HashMap<String , Hall> hallIdVsHall;
    private HashMap<String , User> userIdVsUser;

    public MoviebookingDao()
    {
        this.userVsBooking = new HashMap<>();
        this.cinemaIdVsCinema = new HashMap<>();
        this.showIdVsShow = new HashMap<>();
        this.cityIdVsCity = new HashMap<>();
        this.hallIdVsHall = new HashMap<>();
        this.userIdVsUser = new HashMap<>();
    }

    public void addUser(String name)
    {
        User user = new User(name);
        userIdVsUser.put(user.getId(), user);
    }

    public Cinema addCinema(String name,String cityId)
    {
        Cinema cinema = new Cinema(name);
        if(cityIdVsCity.containsKey(cityId)) {
            cityIdVsCity.get(cityId).addCinema(cinema);
            cinemaIdVsCinema.put(cinema.getId(), cinema);
        }
        return cinema;
    }

    public Hall addHall(String name,String cinemaId)
    {
        Hall hall = new Hall(name);
        if(cinemaIdVsCinema.containsKey(cinemaId))
        {
            Cinema cinema = cinemaIdVsCinema.get(cinemaId);
            cinema.addHall(hall);
            hallIdVsHall.put(hall.getId(), hall);
        }
        return hall;
    }

    public Show addShow(Showname name , Movie movie ,String hallId )
    {
        Show show = new Show(name , movie);
        if(hallIdVsHall.containsKey(hallId))
        {
            hallIdVsHall.get(hallId).addShow(show);
            showIdVsShow.put(show.getId(), show);
        }
        return show;
    }

    public City addCity(String name)
    {
        City city = new City(name);
        cityIdVsCity.put(city.getId(), city);
        return city;
    }

    public void doBooking(Show show,List<Integer> seatNumbers,PaymentType type,Double amt,String hallid)
    {
        Booking booking = new Booking(show.getId(),type,amt);

        List<Seat> seats = hallIdVsHall.get(hallid).getSeatList().stream()
                .filter(seat -> seatNumbers.contains(seat.getSeatNumber()))
                .collect(Collectors.toList());

        show.addBookedSeats(seats);
        booking.addSelectedSeats(seats);

    }

    public void getAvailableSeatsForShow(Hall hall,Show show)
    {
        if(showIdVsShow.containsKey(show.getId()))
        {
            Set<Integer> bookedSeatNumbers = show.getBookedSeats()
                            .stream().map(Seat::getSeatNumber)
                            .collect(Collectors.toSet());

            List<Integer> availableSeatNumbers = hall.getSeatList().stream().filter(seat ->  !bookedSeatNumbers.contains(seat.getSeatNumber()))
                    .map(Seat::getSeatNumber)
                    .collect(Collectors.toList());

            availableSeatNumbers.forEach(System.out::println);
        }

    }


 }
