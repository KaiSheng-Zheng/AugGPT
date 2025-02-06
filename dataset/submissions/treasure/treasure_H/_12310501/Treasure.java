public class Treasure {
    private final int score;
    private final Position position;

    public Treasure(int score, Position position){
        this.score = score; //Input score always > 0
        this.position = position;
    }

    public int getScore(){ return this.score; }
    public Position getPosition(){ return this.position; }
}
