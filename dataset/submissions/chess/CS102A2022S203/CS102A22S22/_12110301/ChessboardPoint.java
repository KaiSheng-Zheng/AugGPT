public class ChessboardPoint {
     public boolean equals(Object ytks)
    {
        if(ytks.getClass()!=this.getClass())
            return false;
        
        if(ytks==null)
            return false;



        ChessboardPoint lukcus=(ChessboardPoint) ytks;
        return y==lukcus.y&&x==lukcus.x;
    }

    private int x;
    private int y;

    public ChessboardPoint(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public boolean check(int x , int y)
    {
       return y>=0&&y<=7&&x>=0&&x<=7;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    public String toString()
    {

        return String.format("(%d,%d)",x,y);

    }

    public ChessboardPoint offset(int dx, int dy)
    {
         if (check(x+dx,y+dy))
            return new ChessboardPoint(x+dx,y+dy);
         else
             return null;

    }

}