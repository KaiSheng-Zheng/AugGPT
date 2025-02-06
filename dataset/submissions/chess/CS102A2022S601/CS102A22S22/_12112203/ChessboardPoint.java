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
        if (x + dx > 7 || x + dx < 0 || y + dy > 7 || y + dy < 0) {
            return null;
        } else {
            return new ChessboardPoint(x + dx, y + dy);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        ChessboardPoint chessboardPoint = (ChessboardPoint) object;
        return x == chessboardPoint.x && y == chessboardPoint.y;
    }
}
