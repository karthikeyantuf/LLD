package SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
   private Cell[][] cells;

    public Board(int n , int snakesCount , int ladderCount)
    {
        initializeBoard(n);
        initializeSnakeAndLadder(snakesCount,ladderCount);
    }

    private void initializeBoard(int n)
    {
        cells = new Cell[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }

    private void initializeSnakeAndLadder(int snakesCount ,int ladderCount)
    {
        while(snakesCount-- > 0)
        {
            int snakeHead = ThreadLocalRandom.current().nextInt(1,cells.length* cells.length+1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,cells.length* cells.length+1);

            if(snakeHead <= snakeTail)continue;

            Jump jumpObj = new Jump();
            jumpObj.start = snakeHead;
            jumpObj.end = snakeTail;

            Cell cell = getCell(snakeHead);
            cell.jump = jumpObj;
        }

        while(ladderCount-- > 0)
        {
            int ladderHead = ThreadLocalRandom.current().nextInt(1,cells.length* cells.length+1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1,cells.length* cells.length+1);

            if(ladderHead >= ladderTail)continue;

            Cell cell = getCell(ladderHead);
            if(cell.jump != null) continue;

            Jump jumpObj = new Jump();
            jumpObj.start = ladderHead;
            jumpObj.end = ladderTail;

            cell.jump = jumpObj;
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int position)
        {
            int row = position/cells.length;
            int col = (position% cells.length);
            return cells[row][col];
        }
}
