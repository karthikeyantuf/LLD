package InventoryManagement;

public class Main {
    public static void main(String args[])
    {
        ReplenishmentStrategy replenishmentStrategy = new JustInTimeStrategy();
        InventoryManager inventoryManager = InventoryManager.getInventoryManagerInstance(replenishmentStrategy);


        WareHouse warehouse1 = new WareHouse("Warehouse 1");
        WareHouse warehouse2 = new WareHouse("Warehouse 2");
        inventoryManager.addWareHouse(warehouse1);
        inventoryManager.addWareHouse(warehouse2);


        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                Enums.ProductCategory.ELECTRONICS, "SKU123", "Laptop", 1000, 50.00, 25);
        Product tShirt = productFactory.createProduct(
                Enums.ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20, 200.00, 100);
        Product apple = productFactory.createProduct(
                Enums.ProductCategory.GROCERY, "SKU789", "Apple", 1, 100.00, 200);


        warehouse1.addProduct(laptop, 15);
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);



        inventoryManager.performInventoryCheck();
    }
}
