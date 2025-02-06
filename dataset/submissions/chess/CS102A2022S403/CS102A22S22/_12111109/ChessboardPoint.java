public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public ChessboardPoint offset(int dx, int dy){
        int xx = x+dx;
        int yy = y+dy;
        if(xx<0||yy<0||xx>7||yy>7) return null;
        else {
            ChessboardPoint chess = new ChessboardPoint(xx,yy);
            return chess;
        }
    }
    public String toString(){
        return String.format("(%d,%d)",x,y);
    }
}
