public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess


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
        String point = "";
        point = "(" + getX() + "," + getY() + ")";
        return point;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int m = getX() + dx;
        int n = getY() + dy;
        if (m < 8 && m >= 0 && n < 8 && n >= 0) {
            return new ChessboardPoint(m, n);
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==null||obj.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint point =(ChessboardPoint) obj;
        if (x==point.x&&y==point.y){
            return true;
        }
        else {
            return false;
        }
    }
}