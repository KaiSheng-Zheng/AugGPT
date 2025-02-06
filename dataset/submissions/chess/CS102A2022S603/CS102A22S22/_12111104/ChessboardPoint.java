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
        return String.format("(%d,%d)",x,y);
    }
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint point=new ChessboardPoint(x+dx,y+dy);
        if (point.getX()>7||point.getY()>7||point.getX()<0||point.getY()<0){
            return null;
        }else {
            return point;
        }
    }
}