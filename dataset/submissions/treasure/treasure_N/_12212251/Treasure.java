public class Treasure {
    private final int score;
    private final Position position;
    private boolean isUsed;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.isUsed = false;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isUsed() {
        return isUsed;
    }
    public void setisUsed() {
        isUsed = !isUsed;
    }
}
