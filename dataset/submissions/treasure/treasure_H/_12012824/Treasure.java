public class Treasure {
    private final int score;

    public int getScore() {
        return score;
    }
    private final Position position;

    public Position getPosition() {
        return position;
    }

    public Treasure(int score, Position position){
        this.position = position;
        this.score = score;
    }
}