public class ChessboardPoint {
    private int x;
    private int y;
    private int value;

    public int getValue() {
        return value=getX()*10+getY();
    }

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
        return String.format("(%d,%d)",x,y);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x+dx>7||y+dy>7||x+dx<0||y+dy<0){
        return null;
        }
    else return new ChessboardPoint(x+dx,y+dy);}
}
