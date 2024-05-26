package VendingMachine;

public class Vendingmachine {
    private IdleState idleState;
    private HasCoinState hasCoinState;
    private DispenseState dispenseState;
    private State currVendingMachineState;
    int amountInserted;
    Inventory inventory;

    public Vendingmachine(int asileCount)
    {
        idleState = new IdleState(this);
        hasCoinState = new HasCoinState(this);
        dispenseState = new DispenseState(this);
        this.currVendingMachineState = idleState;
        amountInserted = 0;
        inventory = new Inventory(asileCount);
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public HasCoinState getHasCoinState() {
        return hasCoinState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public State getCurrVendingMachineState() {
        return currVendingMachineState;
    }

    public int getAmountInserted() {
        return amountInserted;
    }

    public void setCurrVendingMachineState(State currVendingMachineState) {
        this.currVendingMachineState = currVendingMachineState;
    }

    public void setAmountInserted(int amountInserted) {
        this.amountInserted = amountInserted;
    }

    public boolean hasSufficientAmount(int price)
    {
        return amountInserted >= price;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void addProduct(Product product)
    {
        this.inventory.addProduct(product);
    }

    public void selectProduct(int asileNumber)
    {
        try
        {
            this.currVendingMachineState.selectProduct(asileNumber);
            this.currVendingMachineState.dispenseProduct(asileNumber);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void insertCoin(int amount)
    {
        try
        {
            this.currVendingMachineState.insertCoin(amount);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
