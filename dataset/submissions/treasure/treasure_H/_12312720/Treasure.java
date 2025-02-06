//package A4_2;

public class Treasure {
    private final int score;
    private final Position position;
    private int sc;
    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        sc=score;
    }

    public int getScore() {
        return sc;
    }

    public Position getPosition() {
        return position;
    }

    public void setSc(int sc) {
        this.sc = sc;
    }
}
