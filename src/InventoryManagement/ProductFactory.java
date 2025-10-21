package InventoryManagement;

public class ProductFactory {

    public Product createProduct(Enums.ProductCategory productFactory, String sku, String name, Integer quantity, Double price, Integer threshold)
    {
        return switch (productFactory)
        {
            case ELECTRONICS -> new ElectronicsProduct(sku,name,quantity,price,threshold);
            case GROCERY -> new GroceryProduct(sku,name,quantity,price,threshold);
            case CLOTHING -> new ClothingProduct(sku,name,quantity,price,threshold);
            default -> throw new RuntimeException("Unknown product category");
        };
    }
}
