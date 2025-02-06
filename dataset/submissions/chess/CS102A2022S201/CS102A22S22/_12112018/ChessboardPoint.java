public class ChessboardPoint {
    private int x=1;
    private int y=2;
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
    @Override
    public String toString() {
        return "("+x + ","+y+")" ;
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint chess = new ChessboardPoint(x+dx,y+dy);
        if(x+dx<0||x+dx>7||y+dy<0||y+dy>7){
            return null;
        }
        else return chess ;
    }
}