public class Treasure {
    private final int score;
    private final Position position;
    public Treasure(int score,Position position){
        this.score=score;
        this.position=new Position(position.getRow(),position.getCol());
    }

    public int getScore() {return score;}
    public Position getPosition(){return position;}
    public void setPosition(int x,int y){
        position.setRow(x);
        position.setCol(y);
    }
}
