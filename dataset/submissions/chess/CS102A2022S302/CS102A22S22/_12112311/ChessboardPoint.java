public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
        String s = String.format("(%d,%d)", getX(), getY());
        return s;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint chessboardPoint = new ChessboardPoint(this.getX() + dx, this.getY() + dy);
        if (chessboardPoint.getX() < 0 || chessboardPoint.getX() > 7 || chessboardPoint.getY() < 0 || chessboardPoint.getY() > 7) {
            return null;
        }
        return chessboardPoint;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.getX() == o.getX()) {
            if (this.getY() < o.getY()) {
                return -1;
            } else if (this.getY() > o.getY()) {
                return 1;
            }
            return 0;
        }
        if (this.getX() < o.getX()) {
            return -1;
        }
        return 1;


    }
}
