package InventoryManagement;

public class BulkOrderStrategy implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        System.out.println("Bulk order strategy");
    }
}
