package SnakeAndLadder;

public class Player {
    String name;
    int currentPosition;

    public Player(String name , int currentPosition)
    {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}


