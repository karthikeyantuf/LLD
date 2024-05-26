package VendingMachine;

public class HasCoinState implements State{
    private Vendingmachine vendingmachine;

    public HasCoinState(Vendingmachine vendingmachine)
    {
        this.vendingmachine = vendingmachine;
    }
    @Override
    public void insertCoin(int amount) {
        vendingmachine.setAmountInserted(vendingmachine.getAmountInserted()+amount);
    }

    @Override
    public void selectProduct(int asileNumber) {
        Inventory inventory = vendingmachine.getInventory();
        Product product = inventory.getAsileNumberToProduct().get(asileNumber);
        if(!inventory.checkProductAvailability(asileNumber))
        {
            throw new IllegalStateException("Product is not available right now");
        }

        if(!vendingmachine.hasSufficientAmount(product.getPrice()))
        {
            throw new IllegalStateException("Inserted amount not sufficient");
        }

        vendingmachine.setCurrVendingMachineState(vendingmachine.getDispenseState());
    }

    @Override
    public void dispenseProduct(int asileNumber) {

    }

}
