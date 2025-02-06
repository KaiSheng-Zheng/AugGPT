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
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x_new = x + dx;
        int y_new = y + dy;
        if (0 <= x_new && 7 >= x_new && 0 <= y_new && 7 >= y_new) {
            return new ChessboardPoint(x_new,y_new);
        } else return null;
    }
}
