
public class Treasure{
    private final int score;
    private final Position position;
    private boolean found=false;
    public Treasure(int score,Position position){
        this.score=score;
        this.position=new Position(position);
    }
    public int getScore(){
        return score;
    }
    public Position getPosition(){
        return position;
    }
    public String toString(){
        return String.format("%d,%s",score,position);
    }
    public void invalidate(){
        found=true;
    }
    public boolean hasBeenFound(){
        return found;
    }
}