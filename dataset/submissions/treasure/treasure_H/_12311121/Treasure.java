
public class Treasure {
    public void setScore(int score) {
        this.score = score;
    }

    private  int score;

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }

    private final Position position;

    public Treasure(int score, Position position) {
        this.score = score;
        this.position = position;
    }


}
