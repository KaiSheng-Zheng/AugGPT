public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score, Position position){
        this.position=position;
        this.score=score;
    }
    public int getScore(){
        return score;
    }
    public Position getPosition(){
        return position;
    }
}
