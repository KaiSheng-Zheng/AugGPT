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
        return "("+getX()+","+getY()+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */

    public ChessboardPoint offset(int dx, int dy) {
        int a=getX()+dx;
        int b=getY()+dy;

        if ((a>7)||(a<0)||(b>7)||(b<0)) {return null;}
        else return new ChessboardPoint(a,b);
    }
}
