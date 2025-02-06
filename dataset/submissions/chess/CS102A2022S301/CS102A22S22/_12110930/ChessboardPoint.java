public class ChessboardPoint {
    // position of chess
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
        return String.format("(%d,%d)", this.x, this.y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x = this.x + dx;
        int y = this.y + dy;
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            return new ChessboardPoint(x, y);
        } else {
            return null;
        }
    }
}
