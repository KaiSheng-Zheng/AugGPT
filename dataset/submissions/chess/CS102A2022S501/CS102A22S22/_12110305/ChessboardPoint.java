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
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            this.x = x;
            this.y = y;
        }
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
        return String.format("(%d,%d)", x, y);
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx < 8 && x + dx >= 0 && y + dy < 8 && y + dy >= 0) {
            return new ChessboardPoint(x + dx, y + dy);
        } else return null;
    }


    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        ChessboardPoint p = (ChessboardPoint) o;
        if (x == p.x && y == p.y) {
            return true;
        }
        return false;
    }
}
