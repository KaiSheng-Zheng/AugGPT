public class Treasure {
    private final int score;

    public int getScore() {
        return score;
    }

    private final Position pos;

    public Position getPos() {
        return pos;
    }

    public Treasure(int score, Position pos){
        this.pos=pos;
        this.score=score;
    }
}
