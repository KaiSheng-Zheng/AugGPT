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
        if (getX() >= 0 && getX() <= 7 && getY() >= 0 && getY() <= 7) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * should design
     *
     * @return
     */
    public int getX() {
        return x;
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
        return "(" + this.x + "," + this.y + ")";
    }
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint) o;
        return x==p.x&&y==p.y;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint chessboardPoint = new ChessboardPoint(getX() + dx, getY() + dy);
        if (getX() + dx < 0 || getX() + dx > 7 || getY() + dy < 0 || getY() + dy > 7) {
            return null;
        }
        return chessboardPoint;
    }
}