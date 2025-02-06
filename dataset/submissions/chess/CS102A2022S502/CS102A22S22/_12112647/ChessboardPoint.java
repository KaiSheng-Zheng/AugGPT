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
        return "("+x+","+y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int x1=x+dx;
        int y1=y+dy;
        if(x1<0||y1<0||x1>7||y1>7) {
            return null;
        }
        else {
            return new ChessboardPoint(x1, y1);
        }
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(o.getClass()!=this.getClass()){
            return false;
        }
        ChessboardPoint p=(ChessboardPoint) o;
        return x==p.x&&y==p.y;
    }
}
