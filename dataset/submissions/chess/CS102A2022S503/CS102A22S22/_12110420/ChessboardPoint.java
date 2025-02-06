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
        return String.format("(%d,%d)", x, y);
    }


    public ChessboardPoint offset(int dx, int dy) {
        return x + dx < 8 && x + dx >= 0 && y + dy < 8 && y + dy >= 0 ? new ChessboardPoint(x + dx, y + dy) : null;
    }

    @Override
    public boolean equals(Object obj) {
        if (((ChessboardPoint) obj).getX() == getX() && ((ChessboardPoint) obj).getY() == getY()) {
            return true;
        }
        return false;
    }
}
