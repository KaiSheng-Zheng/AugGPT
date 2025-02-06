public class ChessboardPoint {
    private int x;// x: Horizontal location of this chess
    private int y;// y: Vertical location of this chess

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
        int newX = getX() + dx;
        int newY = getY() + dy;
        if (0 <= newX && newX <= 7 && 0 <= newY && newY <= 7) {
            return new ChessboardPoint(newX, newY);
        }
        return null;
    }
}
