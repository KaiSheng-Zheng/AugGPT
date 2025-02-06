
public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score, Position position){
        this.score=score;
        this.position=position;
    }

    public int getScore() {
        int a=score;
        //score=0;
        return a;
    }

    public Position getPosition() {
        return position;
    }

//    public void ssetScore(int score) {
//        this.score = score;
//    }
}
