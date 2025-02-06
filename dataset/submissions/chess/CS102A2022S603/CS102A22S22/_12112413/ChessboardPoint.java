public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public String toString() {
        String s = "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + ")";
        return s;
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (this.x + dx > 7 || this.x + dx < 0 || this.y + dy > 7 || this.y + dy < 0)
            return null;
        ChessboardPoint c = new ChessboardPoint(this.x + dx, this.y + dy);
        return c;
    }
}