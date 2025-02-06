public class Treasure {
    private final int score;
    private final Position position;
    private int trytime;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
        this.trytime = 1;
    }

    public int getTrytime() {
        return trytime;
    }

    public void setTrytime(int trytime) {
        this.trytime = trytime;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
