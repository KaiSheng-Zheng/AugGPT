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
        return "("+x + ","+y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {

        if (this.x+dx>7||this.x+dx<0||this.y+dy>7||this.y+dy<0)
            return null;
        else
            return new ChessboardPoint(this.x+dx,this.y+dy);
    }

    public boolean equals(Object o){
        ChessboardPoint o1=(ChessboardPoint) o;
        if (this.getX()==o1.getX()&&this.getY()==o1.getY())
            return true;
        else
            return false;
    }

}
