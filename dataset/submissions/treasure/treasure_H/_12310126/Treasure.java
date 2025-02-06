public class Treasure {
    private final int score;
    private final Position position;
    private boolean availability =true;
    public Treasure(int score,Position position){
        this.score=score;
        this.position=position;

    }

    public int getScore() {
        return score;
    }

    public Position getPosition() {
        return position;
    }
    public void treasureFound(){
        availability =false;}
    public boolean isAvailability(){return availability;}
}
