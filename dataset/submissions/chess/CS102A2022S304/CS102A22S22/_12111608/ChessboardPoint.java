public class ChessboardPoint {
    private int x;
    private int y;
    private int newX;
    private int newY;
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
        newX=this.x+dx;
        newY=this.y+dy;
        if(newX>=0&&newX<=7&&newY>=0&&newY<=7){
        ChessboardPoint chessboardPoint =new ChessboardPoint(newX,newY);
        return chessboardPoint;
        } else{return null;}
    }
}
