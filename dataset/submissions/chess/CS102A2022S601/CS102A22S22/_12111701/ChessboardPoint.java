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
        return this.x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return this.y;
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

        int xnew = x+ dx;
        int ynew = y+ dy;
        if(xnew < 0 || xnew >7 || ynew <0 || ynew>7){
            return null;
        }else{
            ChessboardPoint tt = new ChessboardPoint(xnew,ynew);
            return tt;
        }

    }
}
