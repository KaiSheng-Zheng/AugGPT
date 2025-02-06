public class ChessboardPoint {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x =  x;
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
        String s="("+this.x+","+this.y+")";
        return s;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if(this.x+dx>7||this.x+dx<0||this.y+dy>7||this.y+dy<0)return null;
        else{
            ChessboardPoint chessboardPoint=new ChessboardPoint(this.x+dx,this.y+dy);
            return chessboardPoint;
        }
    }
}
