package InventoryManagement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClothingProduct extends Product{
    public String size;
    public String color;

    public ClothingProduct(String sku, String name, Integer quantity, Double price, Integer threshold)
    {
        super();
        setSku(sku);
        setName(name);
        setQuantity(quantity);
        setPrice(price);
        setThreshold(threshold);
        setProductCategory(Enums.ProductCategory.CLOTHING);
    }
}
