package InventoryManagement;

import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    List<WareHouse> wareHouses;
    ReplenishmentStrategy replenishmentStrategy;

    private InventoryManager()
    {
    }

    public static synchronized InventoryManager getInventoryManagerInstance(ReplenishmentStrategy replenishmentStrategy)
    {
        if(instance == null)
        {
            instance = new InventoryManager();
        }
        instance.setReplenishmentStrategy(replenishmentStrategy);
        return instance;
    }

    public void addWareHouse(WareHouse wareHouse)
    {
        wareHouses.add(wareHouse);
    }

    public void removeWareHouse(WareHouse wareHouse)
    {
        wareHouses.remove(wareHouse);
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy replenishmentStrategy)
    {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    public void performInventoryCheck()
    {
        for(WareHouse wareHouse : wareHouses)
        {
            for(Product product : wareHouse.getAllProducts())
            {
                if(product.getQuantity() <= product.getThreshold())
                {
                    replenishmentStrategy.replenish(product);
                }
            }
        }
    }

}
