public class ChessboardPoint
{
    private int x;
    private int y;
    public ChessboardPoint(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
//    public boolean checkLegal()
    public int getX()
    {
        return x;
    }
    public static boolean check(int x,int y)
    {
        if(x>=0 && x<=7 && y>=0 && y<=7) return true;
        return false;
    }
    public int getY()
    {
        return y;
    }
    public String toString()
    {
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx,int dy)
    {
        if((x+dx<=7 && x+dx>=0)&&(y+dy<=7 && y+dy>=0))
        {
            return new ChessboardPoint(x+dx,y+dy);
        }
        return null;
    }
}