package MovieBooking;

import java.util.UUID;

public class Movie {
    String id;
    String name;
    String genre;
    String language;

    public Movie(String name,String genre,String language)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.genre = genre;
        this.language = language;
    }
}
