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
        return String.format("(%d,%d)", getX(), getY());
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint chessboardPoint = new ChessboardPoint(getX(), getY());
        chessboardPoint.x += dx;
        chessboardPoint.y += dy;
        if (chessboardPoint.x < 8 && chessboardPoint.y < 8 && chessboardPoint.x >= 0 && chessboardPoint.y >= 0) {
            return chessboardPoint;
        } else {
            return null;
        }
    }
}
