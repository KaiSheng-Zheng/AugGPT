public class ChessboardPoint {  // maintain chess locations in the game.
    private int x;  //Horizontal location of this chess
    private int y;  //Vertical location of this chess

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
        return ("("+getX()+","+getY()+")");
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    //bu chang
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint p1=new ChessboardPoint(getX()+dx,getY()+dy);
        if(getX()+dx>7 ||getY()+dy>7 ||getX()+dx<0 ||getY()+dy<0){
            return null;
        }
        else{
            return p1;
        }
    }
}
