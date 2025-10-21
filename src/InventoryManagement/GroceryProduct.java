package InventoryManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GroceryProduct extends Product{
    public Date date;
    public Boolean isRefrigerated;

    public GroceryProduct(String sku, String name, Integer quantity, Double price, Integer threshold)
    {
        super();
        setSku(sku);
        setName(name);
        setQuantity(quantity);
        setPrice(price);
        setThreshold(threshold);
        setProductCategory(Enums.ProductCategory.GROCERY);
    }
}
