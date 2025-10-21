package InventoryManagement;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product {
    private String sku;
    private String name;
    private Integer quantity;
    private Double price;
    private Integer threshold;
    private Enums.ProductCategory productCategory;
}
