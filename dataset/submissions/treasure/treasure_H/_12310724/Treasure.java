public class Treasure {
    private final int score;
    private final Position position;

    private boolean vis=false;
    public Treasure(int score, Position position){
        this.score=score;this.position=position;
    }
    public int getScore(){return score;}
    public Position getPosition(){return position;}
    public boolean getVis(){return vis;}
    public void setVis(){this.vis=true;}

}
