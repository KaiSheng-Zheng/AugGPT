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
        return "("+x+","+y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int x1 = x + dx;
        int y1 = y + dy;
        if (checkLegal(x1,y1)){
            return new ChessboardPoint(x1,y1);
        }
        return null;
    }

    public boolean checkLegal(int x,int y) {
        if (x < 0 || x > 7) return false;
        if (y < 0 || y > 7) return false;
        return true;
    }
}
