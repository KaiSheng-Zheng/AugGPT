public class Treasure {
    // Fields
    private final int score;
    private final Position position;

    // Constructor
    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
    }


    // Getter for score
    public int getScore() {
        return score;
    }
    // Getter for position
    public Position getPosition() {
        if (this.position != null)
        {return position;}
        else {return null;}
    }
}

