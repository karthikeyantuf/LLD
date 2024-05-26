package VendingMachine;

public interface State {
    public void insertCoin(int amount);
    public void selectProduct(int asileNumber);
    public void dispenseProduct(int asileNumber);
}
