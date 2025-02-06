public class Treasure {
    private final int score;
    private final Position position;

    private boolean isCollected = false;

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

    public boolean isCollected() {
        return isCollected;
    }

    public void collect() {
        System.out.println("Treasure at" + position + " has been collected");
        isCollected = true;
    }
}
