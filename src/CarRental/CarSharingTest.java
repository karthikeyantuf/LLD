package CarRental;

import CarRental.Model.SelectionStrategyType;
import CarRental.Service.Application;

public class CarSharingTest {

    public static void main(String args[])
    {
        Application app = new Application();

        app.add_user("Rohan", 'M', 36);
        app.add_vehicle("Rohan", "Swift", "KA-01-12345");

        app.add_user("Shashank", 'M', 29);
        app.add_vehicle("Shashank", "Baleno", "TS-05-62395");

        app.add_user("Nandini", 'F', 29);

        app.add_user("Shipra", 'F', 27);
        app.add_vehicle("Shipra", "Polo", "KA-05-41491");
        app.add_vehicle("Shipra", "Activa", "KA-12-12332");

        app.add_user("Gaurav", 'M', 29);

        app.add_user("Rahul", 'M', 35);
        app.add_vehicle("Rahul", "XUV", "KA-05-1234");


        app.offer_ride("Rohan", "Hyderabad", 1, "Swift", "KA-01-12345", "Bangalore");
        app.offer_ride("Shipra", "Bangalore", 1, "Activa", "KA-12-12332", "Mysore");
        app.offer_ride("Shipra", "Bangalore", 2, "Polo", "KA-05-41491", "Mysore");
        app.offer_ride("Shashank", "Hyderabad", 2, "Baleno", "TS-05-62395", "Bangalore");
        app.offer_ride("Rahul", "Hyderabad", 5, "XUV", "KA-05-1234", "Bangalore");
        app.offer_ride("Rohan", "Bangalore", 1, "Swift", "KA-01-12345", "Pune");

        app.select_ride("Nandini", "Bangalore", "Mysore", 1, SelectionStrategyType.MOST_VACANT, "None");
        app.select_ride("Gaurav", "Bangalore", "Mysore", 1, SelectionStrategyType.PREFERRED, "Activa");
        app.select_ride("Rohan", "Mumbai", "Bangalore", 1, SelectionStrategyType.PREFERRED, "Baleno");
        app.select_ride("Rohan", "Hyderabad", "Bangalore", 1, SelectionStrategyType.PREFERRED, "Baleno");
        app.select_ride("Shashank", "Hyderabad", "Bangalore", 1, SelectionStrategyType.PREFERRED, "Polo");

        app.end_ride( "KA-01-12345");
        app.end_ride("KA-12-12332");
        app.end_ride( "KA-05-41491");

    }
}
