public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score, Position position){
        this.score=score;
        this.position=new Position(position.getRow(),position.getCol());
        //this.position =position;
        Found =false;
    }
    public boolean Found;

    public int getScore() {
        return score;
    }

    public boolean isFound() {
        return Found;
    }

    public Position getPosition() {
        return position;
    }
}
