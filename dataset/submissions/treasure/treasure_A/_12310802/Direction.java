public enum Direction {
    UP(-1,0),DOWN(1,0),LEFT(0,-1),RIGHT(0,1);
    private final int dx,dy;
    Direction(int x,int y){
        dx=x;dy=y;
    }
    public int getDx(){return dx;}

    public int getDy() {return dy;}
}
