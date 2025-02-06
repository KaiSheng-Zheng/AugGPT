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
        String toOUT = "(" + x + "," + y + ")";
        return toOUT;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (dx + x >= 0 && dx + x < 8 && dy + y >= 0 && y + dy < 8) {
            int a = dx + this.x;
            int b = dy + this.y;
            return new ChessboardPoint(a, b);
        } else {
            return null;
        }
    }
}
