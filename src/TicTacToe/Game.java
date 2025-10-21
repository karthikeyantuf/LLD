package TicTacToe;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private Player currentPlayer;
    public Game(Player player1,Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        currentPlayer = player1;
    }
    public void play()
    {
        while(!board.isBoardFull() && !board.hasWinner())
        {
            int row = getInput();
            int col = getInput();

            board.makeMove(row,col,currentPlayer.getSymbol());
            switchPlayer();
        }

        if(board.hasWinner())
        {
            switchPlayer();
            System.out.println(currentPlayer.getName() + "Wins");
        }
        else {
            System.out.println("It is a draw");
        }
    }

    private void switchPlayer()
    {
        currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public int getInput()
    {
        Scanner scanner = new Scanner(System.in);
        int input;
        while(scanner.hasNextInt())
        {
            input = scanner.nextInt();
            if(input >=0 && input <=2)
            {
                return input;
            }
            else {
                scanner.next();
            }
        }
        return 0;
    }
}
