public enum Direction{
    RIGHT(0,1),
    UP(-1,0),
    LEFT(0,-1),
    DOWN(1,0);
    private final int row,col;
    Direction(int R,int C){row=R;col=C;}
    public int getCol(){return col;}
    public int getRow(){return row;}
}