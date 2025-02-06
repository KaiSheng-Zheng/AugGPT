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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof ChessboardPoint){
            return ((ChessboardPoint) obj).getX() == this.getX() && ((ChessboardPoint) obj).getY() == this.getY();
        }
        return false;
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
        int destX=getX()+dx;
        int destY=getY()+dy;
        if(destX>7||destX<0||destY>7||destY<0)
            return null;
        else
            return new ChessboardPoint(destX,destY);
    }
}
