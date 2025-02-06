public class Treasure {
    private final int score;
    private final Position position;
    private boolean isOut = false;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }
}
