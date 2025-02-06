public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x1 = x + dx;
        int y1 = y + dy;
        if (x1 < 0 || x1 > 7 || y1 < 0 || y1 > 7) {
            return null;
        } else {
            return new ChessboardPoint(x1, y1);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(ChessboardPoint a1) {
        if (a1.getX() == this.x && a1.getY() == this.y) {
            return true;
        } else {
            return false;
        }
    }
}