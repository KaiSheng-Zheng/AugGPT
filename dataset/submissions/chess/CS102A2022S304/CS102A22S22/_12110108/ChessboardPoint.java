public class ChessboardPoint implements Comparable<ChessboardPoint> {
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
        return String.format("(%d,%d)", this.x, this.y);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if ((this.x + dx <= 7 && this.x + dx >= 0) && (this.y + dy <= 7 && this.y + dy >= 0)) {
            ChessboardPoint newchessboardpoint = new ChessboardPoint(this.x + dx, this.y + dy);
            return newchessboardpoint;
        } else return null;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.getX() < o.getX()) {
            return -1;
        } else if (this.getX() > o.getX()) {
            return 1;
        } else
            return this.getY()-o.getY();

    }
}