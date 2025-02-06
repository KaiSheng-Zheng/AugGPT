public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        if (x >= 0 && y >= 0 && x <= 7 && y <= 7) {
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d,%d)", getX(), getY());
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx < 0 || y + dy < 0 || x + dx > 7 || y + dy > 7) {
            return null;
        }
        return new ChessboardPoint(x + dx, y + dy);
    }
}
