package InventoryManagement;

public class JustInTimeStrategy implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        System.out.println("Just in time replenishment strategy");
    }
}
