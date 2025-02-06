public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x=x;
        this.y=y;
    }
    public ChessboardPoint(){}
    public int getX(){return x;}
    public int getY(){return y;}
    @Override
    public String toString(){
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        if (x+dx>7||x+dx<0||y+dy>7||y+dy<0){
            return null;
        }
        return new ChessboardPoint(x+dx,y+dy);
    }
}