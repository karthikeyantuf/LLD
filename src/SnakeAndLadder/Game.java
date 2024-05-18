package SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players = new LinkedList<>();
    Player winner = null;

    public Game()
    {
        board = new Board(10,5,4);
        dice = new Dice(1);
        initializePlayers();
    }

    private void initializePlayers()
    {
        Player divakar = new Player("Vicky",0);
        Player karthi =  new Player("Divakar",0);

        players.add(divakar);
        players.add(karthi);
    }

    public void startGame()
    {
        while(winner == null)
        {
            Player player = getPlayer();

            System.out.println("Current Player --->"+player.getName() + "And Current position is ---> "+player.getCurrentPosition());

            int diceNumber = dice.rollDice();
            int newPosition = player.getCurrentPosition() + diceNumber;

            newPosition = jumpCheck(newPosition);
            player.setCurrentPosition(newPosition);

            System.out.println("Current Player --->"+player.getName() + "And Current position is ---> "+player.getCurrentPosition());

            if(player.getCurrentPosition() >= board.getCells().length * board.getCells().length -1)
            {
                winner = player;
                System.out.println("Winner --->"+player.getName());
            }
        }
    }

    private Player getPlayer()
    {
        Player player = null;
        if (!players.isEmpty())
        {
            player = players.removeFirst();
            players.addLast(player);
        }
        return player;
    }

    private int jumpCheck(int position)
    {
        if(position > board.getCells().length * board.getCells().length -1)return position;

        Cell cell = board.getCell(position);

        if(cell.getJump() != null && cell.getJump().getStart() == position)
        {
            String x = (cell.getJump().getStart() > cell.getJump().getEnd()) ? "Snake" : "Ladder";
            System.out.println("Hit by a "+x);
            return cell.getJump().getEnd();
        }

        return position;
    }
}
