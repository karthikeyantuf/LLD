package VendingMachine;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Inventory {
    Queue<Integer> asileAvailable;
    HashMap<Integer,Product> asileNumberToProduct;
    HashMap<String,Integer> productIdtToProductCount;

    public Inventory(int asileCount)
    {
        asileAvailable = new LinkedList<>();
        for(int i=1;i<=asileCount;i++)
        {
            asileAvailable.add(i);
        }

        asileNumberToProduct = new HashMap<>();
        productIdtToProductCount = new HashMap<>();
    }

    public boolean checkProductAvailability(int  asileNumber)
    {
        Product product = asileNumberToProduct.get(asileNumber);
        return productIdtToProductCount.get(product.getId()) >=1;
    }

    public void addProduct(Product product)
    {
        String productId = product.getId();
        int productCount = productIdtToProductCount.getOrDefault(productId,0);
        if(productCount == 0)
        {
            if(asileAvailable.isEmpty())
            {
                throw new IllegalStateException("No Asile Available");
            }
            asileNumberToProduct.put(asileAvailable.poll(),product);
        }
        productIdtToProductCount.put(productId,productCount+1);

    }
    public void removeProduct(int asileNumber)
    {
        Product product = asileNumberToProduct.get(asileNumber);
        productIdtToProductCount.remove(product.getId());
        asileNumberToProduct.remove(asileNumber);
        asileAvailable.add(asileNumber);
    }

    public void decrementProductCount(int asileNumber)
    {
        Product product = asileNumberToProduct.get(asileNumber);
        int productCount = productIdtToProductCount.get(product.getId());
        if(productCount == 1)
        {
          removeProduct(asileNumber);
        }
        else {
            productIdtToProductCount.put(product.getId(),productCount-1);
        }
    }

    public HashMap<Integer, Product> getAsileNumberToProduct() {
        return asileNumberToProduct;
    }
}
