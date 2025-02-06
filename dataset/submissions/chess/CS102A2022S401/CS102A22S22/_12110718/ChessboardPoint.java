public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

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
        return "(" + getX() + "," + getY() + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (getX() + dx > 7 || dy + getY() > 7 || getX() + dx < 0 || getY() + dy < 0) {
            return null;
        } else {
            return new ChessboardPoint(getX() + dx, dy + getY());
        }
    }
}
