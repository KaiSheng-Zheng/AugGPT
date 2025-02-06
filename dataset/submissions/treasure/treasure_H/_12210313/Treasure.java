public class Treasure {
    private final int score;
    private final Position position;
    private int exist = 1;
    public Treasure(int score, Position position){
        this.score = score;
        this.position = position;}
    public int getScore(){
        return score;}
    public Position getPosition(){
        return position;}

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }
}