public class Treasure {
    private final int score;
    private final Position position;
    public boolean isFound;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.isFound = false;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
