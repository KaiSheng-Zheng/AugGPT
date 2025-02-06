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
        return String.format("(%d,%d)",x,y);
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
    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (this.getX() + dx > 7 || this.getY() + dy > 7) {
            return null;
        } else if (this.getX() + dx < 0 || this.getY() + dy < 0) {
            return null;
        } else {
            int a = this.getX() + dx;
            int b= this.getY() + dy;
            return new ChessboardPoint(a,b);
        }
    }
}
