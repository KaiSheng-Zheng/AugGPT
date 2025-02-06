public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    @Override
    public String toString() {
        return "(" + x +","+ y +")" ;
    }
    public ChessboardPoint offset(int dx, int dy){
        int xx=this.x;
        int yy=this.y;
        if(xx+dx>=0&&xx+dx<=7 && yy+dy>=0&&yy+dy<=7 ) {
            ChessboardPoint point = new ChessboardPoint(xx + dx, yy + dy);
            return point;
        }
        return null;
    }
}
