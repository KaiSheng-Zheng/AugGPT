public class ChessboardPoint {
    private int x, y;
    private ChessboardPoint chessboardPoint;
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
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if ((x+dx<0||x+dx>7)||(y+dy<0||y+dy>7)){
            return null;
        }
        else {
            return new ChessboardPoint(x+dx,dy+y);
        }
    }
}