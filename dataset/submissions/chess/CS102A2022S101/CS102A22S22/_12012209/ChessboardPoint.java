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

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y) {
        this.y = y;
    }


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        if((this.x>=0&&this.x<=7)&&(this.y>=0&&this.y<=7))
            return String.format("(%d,%d)",this.x,this.y);
        else return null;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if((this.x+dx>=0&&this.x+dx<=7)&&(this.y+dy>=0&&this.y+dy<=7))
            return new ChessboardPoint(this.x+dx,this.y+dy);
        else return null;
    }
}