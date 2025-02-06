public class Treasure {
    private int score;
    private final Position position;
    public Treasure(int score, Position position){
        this.score = score;
        this.position = position;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore(){
        return this.score;
    }
    public Position getPosition(){
        return this.position;
    }
    public String toString() {
        return "Treasure{score = " + score + ", position = " + position + "}";
    }
}