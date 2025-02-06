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
        return this.x;
    }

    /**
     * should design
     *
     * @return
     */
    public int getY() {
        return this.y;
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
        int nx = getX() + dx;
        int ny = getY() + dy;
        if (nx <= 7 && nx >= 0 && ny <= 7 && ny >= 0) {
            return new ChessboardPoint(nx, ny);
        } else {
           return null;
        }
    }
}
