public class Treasure {
    private final int score;
    private final Position position;
    private boolean isFounded = false;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.isFounded = false;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isFounded() {
        return isFounded;
    }

    public void setFounded() {
        isFounded = true;
    }
}
