public class Treasure {
    private final int score;
    private final Position position;
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
        isActive=true;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}