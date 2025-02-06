public class ChessboardPoint    {
    private int x = 0;
    private int y = 0;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint a=new ChessboardPoint(x+dx,y+dy);
        if (x+dx>7||x+dx<0||y+dy>7||y+dy<0){
            return null;
        }
        else return a;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
