public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score, Position pos){
        this.score=score;
        this.position=pos;
    }
    public int getScore(){
        return this.score;
    }
    public Position getPos(){
        return this.position;
    }
}