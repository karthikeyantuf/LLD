package VendingMachine;

public class IdleState implements State{
    private Vendingmachine vendingmachine;

    public IdleState(Vendingmachine vendingmachine)
    {
        this.vendingmachine = vendingmachine;
    }
    @Override
    public void insertCoin(int amount) {
        vendingmachine.setAmountInserted(amount);
        vendingmachine.setCurrVendingMachineState(vendingmachine.getHasCoinState());
    }

    @Override
    public void selectProduct(int asileNumber) {
        throw new IllegalStateException("Product can't be selected before inserting coin");
    }

    @Override
    public void dispenseProduct(int asileNumber) {
        throw new IllegalStateException("Product can't be dispensed before inserting coin");
    }
}
