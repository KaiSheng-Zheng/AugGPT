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
        String re = String.format("(%d,%d)",x,y);
        return re;
    }
    
    public ChessboardPoint offset(int dx, int dy) {
        int xf = x+dx;
        int yf = y+dy;
        if (xf<0||xf>7||yf<0||yf>7) {
            return null;
        } else return new ChessboardPoint(xf,yf);
    }
}
