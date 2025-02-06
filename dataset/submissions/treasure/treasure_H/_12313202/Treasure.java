public class Treasure {
    private final int score;
    private final Position position;

    public Treasure (int score, Position position) {
        this.score = score;
        this.position = position;
    }

    int getScore() { return this.score; }
    Position getPosition() { return this.position; }
}
