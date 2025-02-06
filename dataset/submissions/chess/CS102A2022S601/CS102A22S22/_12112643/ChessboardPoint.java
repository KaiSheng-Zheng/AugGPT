public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        String r = "";
        r = "(" + x + "," + y + ")";
        return r;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint tp;
        if (x + dx <= 7 && x + dx >= 0 && y + dy <= 7 && y + dy >= 0) {
            tp = new ChessboardPoint(x + dx, y + dy);
        }else {
            tp = null;
        }
        return  tp;
    }
}
