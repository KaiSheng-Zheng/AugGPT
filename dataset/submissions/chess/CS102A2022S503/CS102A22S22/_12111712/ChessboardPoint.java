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
        return "(" + this.getX() + "," + this.getY() + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int newX = this.getX() + dx;
        int newY = this.getY() + dy;
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7) {
            return null;
        }
        return new ChessboardPoint(newX, newY);
    }
}
