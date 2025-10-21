package TicTacToe;

public class Board {
    private char[][] board;
    int movesCount;

    public Board()
    {
        board = new char[3][3];
        intializeBoard();
    }

    public void intializeBoard()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                this.board[i][j] = '-';
            }
        }
    }

    public boolean isBoardFull()
    {
        return (movesCount == 9);
    }

    public void makeMove(int row,int col,Character symbol)
    {
        if(row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-')
        {
            throw new IllegalArgumentException("Invalid move");
        }
        board[row][col] = symbol;
        movesCount++;
    }

    public boolean hasWinner()
    {
        for(int row = 0; row <3; row++)
        {
            if(board[row][0] != '-' && board[row][0] == board[row][1] && board[row][1] == board[row][2])
            {
                return true;
            }
        }

        for(int col = 0; col <3 ; col++)
        {
            if(board[0][col] != '-' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

        if(board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;

        if(board[2][0] != '-' && board[2][0] == board[1][1] && board[1][1] == board[0][2]) return true;

        return false;
    }
}
