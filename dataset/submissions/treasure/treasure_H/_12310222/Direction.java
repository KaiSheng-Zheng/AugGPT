public enum Direction {
    LEFT(0,-1),RIGHT(0,1),UP(-1,0),DOWN(1,0);
    private int x;
    private int y;
    private Direction(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
}
