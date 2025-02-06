public class Treasure {
    private final int score; //final variable;
    private final Position position;

    public Treasure(int score, Position position){ //constructor method;
        this.score = score;
        this.position = position;
    }

    public int getScore() {
        return score;
    }
    public Position getPosition() {
        return position;
    }
}