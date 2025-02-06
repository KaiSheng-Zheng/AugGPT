
public class Treasure {
    private final int score;
    private final Position position;
    private boolean collected = false;

    public int getScore() {
        return score;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public Position getPosition() {
        return position;
    }

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = new Position(position.getRow(),position.getCol());
    }
}
