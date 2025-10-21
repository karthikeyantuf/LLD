package TicTacToe;

public class Player {
    private String name;
    private Character symbol;

    public Player(String name,Character symbol)
    {
        this.name = name;
        this.symbol = symbol;
    }

    public Character getSymbol()
    {
        return symbol;
    }

    public String getName()
    {
        return name;
    }
}
