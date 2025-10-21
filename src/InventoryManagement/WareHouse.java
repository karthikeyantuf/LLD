package InventoryManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class WareHouse {
    private int id;
    private String name;
    private String location;
    private Map<String, Product> products;

    public WareHouse(String name)
    {
        this.name = name;
        products = new HashMap<>();
    }

    public void addProduct(Product product, Integer quantity)
    {
        if(products.containsKey(product.getSku()))
        {
            Product existingProduct = products.get(product.getSku());
            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
        }
        else {
            product.setQuantity(product.getQuantity() + quantity);
            products.put(product.getSku(), product);
        }
    }

    public void removeProduct(Product product, Integer quantity)
    {
        String sku = product.getSku();
        if(products.containsKey(sku))
        {
            if(products.get(sku).getQuantity() >= quantity)
            {
                Product existingProduct = products.get(sku);
                existingProduct.setQuantity(existingProduct.getQuantity() - quantity);
            }
            else
            {
                System.out.println("Insufficient quantity");
            }
        }
        else {
            System.out.println("Product not found");
        }
    }

    public Collection<Product> getAllProducts()
    {
        return products.values();
    }

    public Product getProductBySku(String sku)
    {
        return products.get(sku);
    }

    public Integer getAvailableQuantityOFProduct(String sku)
    {
        if(products.containsKey(sku))
        {
            return products.get(sku).getQuantity();
        }
        else {
            System.out.println("Product not found");
        }
        return 0;
    }
}
