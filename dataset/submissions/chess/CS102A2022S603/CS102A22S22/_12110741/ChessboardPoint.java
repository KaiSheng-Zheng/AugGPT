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
        return "("+x+ ","+y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        int x2=x+dx;
        int y2=y+dy;
        ChessboardPoint chessboardPoint1 =new ChessboardPoint(x2,y2);
        if (x2<8&&y2<8){
            return chessboardPoint1;
        }else {
            return null;
        }
    }
}
