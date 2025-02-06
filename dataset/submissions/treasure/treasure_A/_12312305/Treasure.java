

public class Treasure {
    public void setScore(int score) {
        this.score = score;
    }

    private  int score;
    private final Position position;

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    public Treasure(int a, Position b) {
        score = a;
        position = b;
    }
}
