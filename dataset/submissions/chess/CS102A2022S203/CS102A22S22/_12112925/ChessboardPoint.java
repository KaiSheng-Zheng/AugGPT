public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y)
    {
        this.x=x;
        this.y=y;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString()
    {
        return "("+this.x+","+this.y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        if((this.x+dx)>7||(this.x+dx)<0||(this.y+dy)<0||(this.y+dy)>7)return null;
        return new ChessboardPoint(this.x+dx,this.y+dy);
    }
}
