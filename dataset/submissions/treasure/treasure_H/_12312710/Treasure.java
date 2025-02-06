public class Treasure {
    private int score;
    private final Position position;
    private boolean findedornot=true;
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
    public void finded(){
        this.score=0;
        findedornot=false;
    }
    public boolean isFindedornot(){
        return findedornot;
    }
}