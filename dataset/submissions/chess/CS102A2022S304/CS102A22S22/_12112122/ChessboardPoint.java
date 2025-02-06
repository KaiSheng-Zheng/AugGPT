public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     *
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return ("(" + x + "," + y + ")");
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx > 7 || x + dx < 0 || y + dy > 7 || y + dy < 0) {
            return null;
        } else return new ChessboardPoint(x + dx, y + dy);
    }

    public boolean equal(ChessboardPoint p2) {
        return (this.x == p2.getX() && this.y == p2.getY());
    }

    public static ChessboardPoint min(ChessboardPoint p1, ChessboardPoint p2) {
        if (p1.getX() < p2.getX()) return p1;
        else if (p1.getX() == p2.getX()) {
            if (p1.getY() < p2.getY()) return p1;
            else return p2;
        } else return p2;
    }

    public static ChessboardPoint max(ChessboardPoint p1, ChessboardPoint p2) {
        if (p1.getX() < p2.getX()) return p2;
        else if (p1.getX() == p2.getX()) {
            if (p1.getY() < p2.getY()) return p2;
            else return p1;
        } else return p1;
    }
}