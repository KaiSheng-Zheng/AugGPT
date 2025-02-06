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
        String s = String.format("(%d,%d)",x,y);
        return s;
    }
    public ChessboardPoint offset(int dx, int dy) {
        int x1 = x + dx;
        int y1 = y + dy;
        if(x1>=0 && x1<8 && y1>=0 && y1<8){
            return new ChessboardPoint(x1,y1);
        }
        return null;
    }
}