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
    public String toString() {
        return "("+x+","+y+")";
    }
    public ChessboardPoint offset(int dx, int dy) {
        int a = x + dx;
        int b = y + dy;
        ChessboardPoint c = new ChessboardPoint(a,b);
        if (check(a)&&check(b)) {
            return c;
        } else {
            return null;
        }
    }
    public ChessboardPoint setChessboard(int a,int b) {
        x = a;
        y = b;
        ChessboardPoint c = new ChessboardPoint(x,y);
        return c;
    }
    public static boolean check(int a) {
        if ((a <= 7)&&(a >= 0)) {
            return true;
        } else {
            return false;
        }
    }
}
