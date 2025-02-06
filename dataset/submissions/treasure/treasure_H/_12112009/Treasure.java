public class Treasure {
    private final int score;
    private final Position position;
    private boolean b=true;

    public Position getPosition() {
        return position;
    }
    public boolean getboo(){
        return b;
    }
    public void setboo(boolean a){
        this.b=a;
    }

    public int getScore() {
        return score;
    }

    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;

    }
}