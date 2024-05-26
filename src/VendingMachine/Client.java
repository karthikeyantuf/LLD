package VendingMachine;

public class Client {
    public static final int MAX_PRODUCT_COUNT = 3;
    public static void main(String args[])
    {
        Vendingmachine vendingmachine = new Vendingmachine(3);

        Product lays = new Product("Lays",5);
        Product coke = new Product("Coke",50);
        Product munch = new Product("Munch",20);

        for(int i=0;i<MAX_PRODUCT_COUNT;i++)
        {
            vendingmachine.addProduct(lays);
            vendingmachine.addProduct(coke);
            vendingmachine.addProduct(munch);
        }

        vendingmachine.insertCoin(5);
        vendingmachine.selectProduct(3);
    }
}
