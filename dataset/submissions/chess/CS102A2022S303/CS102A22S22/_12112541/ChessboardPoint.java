

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param
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
    public int getX() {return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "("+this.x+","+this.y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if ((x+dx>=0&&x+dx<=7)&&(y+dy>=0&&y+dy<=7))
            return new ChessboardPoint(x+dx,y+dy);
        else
            return null;
    }
}