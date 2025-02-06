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
        ChessboardPoint chessboardPoint = new ChessboardPoint(this.x + dx, this.y + dy);
        if (this.x + dx > 7 || this.x + dx < 0 || this.y + dy > 7 || this.y + dy < 0) {
            return null;
        } else {
            return chessboardPoint;
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessboardPoint chess = (ChessboardPoint) o;
        if (x != chess.x) {
            return false;
        }
        if (y != chess.y) {
            return false;
        }
        return true;
    }
}
