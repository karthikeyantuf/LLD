package VendingMachine;

import java.util.UUID;

public class Product {

    String id;
    String name;
    int price;

    public Product(String name,int price)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
