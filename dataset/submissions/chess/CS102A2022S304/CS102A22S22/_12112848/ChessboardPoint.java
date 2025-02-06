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
        return String.format("(%d,%d)", this.x, this.y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (this.x + dx >= 0 && this.x + dx <= 7
                && this.y + dy >= 0 && this.y + dy <= 7) {
            return new ChessboardPoint(this.x + dx, this.y + dy);
        } else {
            return null;
        }
    }
}
