public class Treasure{
    private final int score;
    private final Position position;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
    }

    // Getter method for score
    public int getScore() {
        return score;
    }

    // Getter method for position
    public Position getPosition() {
        return position;
    }
}