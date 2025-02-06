
public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
    }
    public int getScore() {
        return score;
    }
    public String toString(){
        return position.getRow()+" "+ position.getCol()+" "+score;
    }
    public Position getPosition() {
        return position;
    }
}