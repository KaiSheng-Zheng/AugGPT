public class Treasure {
    private final int score;
    private final Position position;
    private boolean isActive;

    public Treasure(int score,Position position){
        this.score = score;
        this.position = position;
        this.isActive = true;
    }

    public int getScore(){
        return this.score;
    }
    public Position getPosition(){
        return this.position;
    }

    public void has (){
        this.isActive = false;
    }
    public boolean getSituation(){return this.isActive;}
}
