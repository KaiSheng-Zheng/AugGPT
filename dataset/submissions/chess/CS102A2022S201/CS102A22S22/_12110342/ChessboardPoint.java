public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    };

    public int getY() {
        return y;
    };

    public String toString() {

        return "("+getX()+","+getY()+")";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx < 8 && x + dx >= 0 && y + dy < 8 && y + dy >= 0) {
            ChessboardPoint chessboardPoint = new ChessboardPoint(getX() + dx, getY() + dy);
            return chessboardPoint;
        } else {
            return null;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint chess = (ChessboardPoint) o;
        if (x != chess.x) return false;
        if (y != chess.y) return false;
        return true;
    }
}