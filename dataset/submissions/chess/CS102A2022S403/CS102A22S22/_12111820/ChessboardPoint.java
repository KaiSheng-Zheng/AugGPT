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
        return String.format("(%s,%s)",getX(),getY());
    }

    public ChessboardPoint offset(int dx, int dy) {
        int a = x;
        int b = y;
        ChessboardPoint chessboardPoint = new ChessboardPoint(a+=dx,b+=dy);
        if (a < 0 || a > 7 || b < 0 || b > 7){
            return null;
        }
        return chessboardPoint;
    }
}
