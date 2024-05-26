package VendingMachine;

public class DispenseState implements State{

    private Vendingmachine vendingmachine;

    public DispenseState(Vendingmachine vendingmachine)
    {
        this.vendingmachine = vendingmachine;
    }

    @Override
    public void insertCoin(int amount) {
        throw new IllegalStateException("Coin can not be inserted, Product is already in the state of dispensing");
    }

    @Override
    public void selectProduct(int asileNumber) {
        throw new IllegalStateException(" Product can not be selected, Product is already in the state of dispensing");
    }

    @Override
    public void dispenseProduct(int asileNumber) {
        Inventory inventory = vendingmachine.getInventory();
        Product product = inventory.getAsileNumberToProduct().get(asileNumber);

        int changeToReturn = vendingmachine.getAmountInserted() - product.getPrice();
        System.out.println(product.getName()+" dispensed pls collect");
        if(changeToReturn >= 1)
        {
            System.out.println("Pls collect the change "+changeToReturn);
        }

        vendingmachine.setAmountInserted(0);
        inventory.decrementProductCount(asileNumber);
        vendingmachine.setCurrVendingMachineState(vendingmachine.getIdleState());
    }
}
