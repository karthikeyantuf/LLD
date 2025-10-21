package TicTacToe;

public class TicTacToeDemo {
    public static void run()
    {
        Player player1 = new Player("player 1",'X');
        Player player2 = new Player("player 2",'Y');
        Game game = new Game(player1, player2);
        game.play();
    }

}
