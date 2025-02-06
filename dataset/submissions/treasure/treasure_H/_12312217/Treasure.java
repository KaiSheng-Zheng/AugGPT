public class Treasure {
    private final int score;
    private int score2;
    private final Position position;
    public Treasure(int score, Position position){
        this.position=position;
        this.score=score;
        this.score2=score;
    }
    public int getScore(){
        return this.score2;
    }
    public Position getPosition(){
        return this.position;
    }
    public void setScore(int score){
        this.score2=score;
    }

}
