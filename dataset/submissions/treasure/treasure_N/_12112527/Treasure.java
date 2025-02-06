
public class Treasure {
    private  int score;
    private Position position;
    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
}
