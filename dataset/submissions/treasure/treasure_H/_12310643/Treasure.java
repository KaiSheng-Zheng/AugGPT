public class Treasure {
    private final int score;
    private final Position position;
    private int another;

    public int getAnother() {
        return another;
    }

    public void setAnother(int another) {
        this.another = another;
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }
    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
        this.another=score;
    }
}
