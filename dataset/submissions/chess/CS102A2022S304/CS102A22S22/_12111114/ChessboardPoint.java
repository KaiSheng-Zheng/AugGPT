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
        return "(" + x + "," + y + ")";
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */


    public ChessboardPoint offset(int dx, int dy) {
        if (dx + x >= 0 && dx + x <= 7 && dy + y >= 0 && dy + y <= 7) {
            return new ChessboardPoint(dx + x, dy + y);
        } else {
            return null;
        }
    }
}