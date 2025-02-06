public class Treasure {
    private final int score;
    private final Position position;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        isActive=true;
    }

    public int getScore() {
        return score;
    }
    private boolean isActive;

    public boolean getisActive() {
        return isActive;
    }


    public void setActive(boolean active) {
        isActive = active;
    }

    public Position getPosition() {
        return position;
    }
}
