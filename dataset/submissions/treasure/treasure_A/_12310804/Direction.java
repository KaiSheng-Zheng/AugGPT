public enum Direction
{
    RIGHT(0,1),
    UP(-1,0),
    LEFT(0,-1),
    DOWN(1,0);
    private final int row; // represents the direction of row
    private final int col; // represents the direction of column
    Direction(int r,int c)
    {
        row=r;col=c;
    }

    public int getCol()
    {
        return col;
    }

    public int getRow()
    {
        return row;
    }
}
