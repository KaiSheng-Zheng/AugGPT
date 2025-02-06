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
        return "(" + x + "," + y + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy){
        int X = x + dx;
        int Y = y + dy;
        if((X <= 7 && X >= 0) && (Y >= 0 && Y <= 7)){
            return new ChessboardPoint(X, Y);
        }else return null;
    }

    public ChessboardPoint getChessboardPoint(){
        return this;
    }
}
