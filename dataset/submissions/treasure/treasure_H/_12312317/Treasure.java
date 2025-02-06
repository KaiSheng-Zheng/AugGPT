public class Treasure {
//    Fields
    private final int score;
    private final Position position;

//    Constructors
    public Treasure(int score, Position position){
        this.score = score;
        this.position = position;
    }

//    set,get
    public int getScore() {
        return score;
    }
    public Position getPosition() {
        return position;
    }
}
