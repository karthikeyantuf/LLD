package InventoryManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectronicsProduct extends Product{
    private String brand;
    private Integer warrantyPeriod;

    public ElectronicsProduct(String sku, String name, Integer quantity, Double price, Integer threshold)
    {
        super();
        setSku(sku);
        setName(name);
        setQuantity(quantity);
        setPrice(price);
        setThreshold(threshold);
        setProductCategory(Enums.ProductCategory.ELECTRONICS);
    }
}
