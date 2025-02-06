public class Treasure {
    private final int score;
    private final Position position;

    public Treasure(int score, Position pos) {
        this.score = score;
        this.position = pos;
    }

    @Override
    public String toString() {
        return "Treasure{" +
                "score=" + score +
                ", pos=" + position +
                '}';
    }

    public int getScore() {
        return score;
    }

    public Position getPos() {
        return position;
    }
}
