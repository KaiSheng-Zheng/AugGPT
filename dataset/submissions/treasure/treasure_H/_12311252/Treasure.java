public class Treasure {
    private final int score;
    private final Position pos;
    Treasure(int score,Position pos){
        this.score=score;
        this.pos=pos;
    }
    public int getScore(){
        return score;
    }

    public Position getPos() {
        return pos;
    }
}
