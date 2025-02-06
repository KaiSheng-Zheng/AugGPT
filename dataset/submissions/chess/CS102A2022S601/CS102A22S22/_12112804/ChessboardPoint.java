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
        return "("+String.valueOf(x)+","+String.valueOf(y)+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int newx=x+dx;
        int newy=y+dy;
        if(newx>7||newy>7||newx<0||newy<0)
            return null;
        else
            return new ChessboardPoint(newx,newy);
    }
    public void move(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
public boolean equals(Object o){
    if(o==null){
        return false;
} if(o.getClass()!=this.getClass()){
        return false;
    }
ChessboardPoint p=(ChessboardPoint)o;
    return x==p.x&&y==p.y;
}
}
