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
        return String.format("(%s,%s)",x,y);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    //return a new chessboardPoint after moving
    public ChessboardPoint offset(int dx, int dy) {
        if((x+dx<=7&&x+dx>=0&&y+dy<=7&&y+dy>=0)) {
            ChessboardPoint chessboardPoint = new ChessboardPoint(x + dx, y + dy);
            return chessboardPoint;
        }
        else {
            return null;
        }
    }
}
