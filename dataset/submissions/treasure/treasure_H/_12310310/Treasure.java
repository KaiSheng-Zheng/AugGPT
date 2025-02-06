public class Treasure {
    private final int score;
    private final Position position;

    public Treasure(int score, Position position) {
        this.score = (Math.max(score, 0));
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
