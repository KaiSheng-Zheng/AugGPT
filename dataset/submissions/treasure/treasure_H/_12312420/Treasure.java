public class Treasure {
    private int score;
    private Position position;
    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
    }
    public int getScore() {
        return score;
    }
    public Position getPosition() {
        return position;
    }
    public void clr(){
        this.score=0x3f3f3f3f;
    }
}
