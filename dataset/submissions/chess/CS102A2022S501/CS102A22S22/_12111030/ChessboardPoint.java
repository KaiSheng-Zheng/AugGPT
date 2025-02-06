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
        String A = "("+getX()+","+getY()+")";
        return A;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int desx = dx+getX();int desy = dy+getY();
        if((getX()+dx>7)||(getX()+dx<0)||(getY()+dy>7)||(getY()+dy<0)){
            return null;
        }
        else{
            return new ChessboardPoint(desx,desy);
        }
    }
}
