public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
    int x2=0;
    int y2=0;
    public ChessboardPoint offset(int dx, int dy) {
        x2=x+dx;
        y2=y+dy;
        ChessboardPoint point = new ChessboardPoint(x2,y2);
        if(0<=x2&&x2<=7){
            if(0<=y2&&y2<=7){
                return point;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}