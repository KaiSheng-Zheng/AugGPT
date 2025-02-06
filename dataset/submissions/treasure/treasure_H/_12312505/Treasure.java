public class Treasure {
    private final int score;
    private final Position position;
    private boolean isValid=true;

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isValid() {
        return isValid;
    }

    public Treasure(int score, Position position) {
        this.score=score;
        this.position=position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
