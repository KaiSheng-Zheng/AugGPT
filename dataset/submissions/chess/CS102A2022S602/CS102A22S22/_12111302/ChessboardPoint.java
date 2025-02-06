public class ChessboardPoint {
    private int x;
    private int y;
    private ChessColor chessColor=getChessColor();

    /**
     * should design
     * @param x
     * @param
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public ChessboardPoint(int x, int y, ChessColor chessColor) {
        this.x = x;
        this.y = y;
        this.chessColor=chessColor;
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
    public ChessColor getChessColor()
    {return chessColor;}
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
        if(x+dx>7||x+dx<0||y+dy>7||y+dy<0)
        {
            return null;
        }
        else
        {
            ChessboardPoint chessboardPoint=new ChessboardPoint(x+dx,y+dy);
            return chessboardPoint;
        }
    }
}
