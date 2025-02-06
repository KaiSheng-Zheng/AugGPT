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
        if(getX()+dx<8 && getY()+dy<8 && getX()+dx>-1 &&getY()+dy>-1){
            int xx=dx+getX();
            int yy=dy+getY();
            ChessboardPoint cbp=new ChessboardPoint(xx,yy);
            return cbp;
            // return new ChessboaardPoint(x+dx,y+dy)
        }
        else
            return null;
    }
}