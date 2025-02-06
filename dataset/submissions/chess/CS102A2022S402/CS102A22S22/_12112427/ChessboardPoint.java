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
        return "(" + this.x + "," + this.y + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int a = this.x + dx;
        int b = this.y + dy;
        ChessboardPoint ab = new ChessboardPoint(a, b);
        if (a >= 0 && a <= 7 && b >= 0 && b <= 7) {
            return ab;
        } else {
            return null;
        }
    }
}
