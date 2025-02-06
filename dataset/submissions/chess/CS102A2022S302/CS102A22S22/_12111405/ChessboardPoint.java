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

        return "(" + String.valueOf(getX()) + "," + String.valueOf(getY()) + ")";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int x = getX() + dx;
        int y = getY() + dy;
        ChessboardPoint last = new ChessboardPoint(0, 0);


        if (x <= 7 && y <= 7 && x >= 0 && y >= 0) {
            last.setX(x);
            last.setY(y);
            return last;
        } else return null;
    }
}