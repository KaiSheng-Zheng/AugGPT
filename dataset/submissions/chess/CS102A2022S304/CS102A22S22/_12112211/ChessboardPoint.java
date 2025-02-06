public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
     */
     public ChessboardPoint(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            this.x = x;
            this.y = y;
        }else {
            this.x = -1;
            this.y = -1;
        }
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
        return "(" +this.x+","+this.y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint ans = new ChessboardPoint(dx+x,dy+y);
        if (dx+x < 0 || dx+x> 7 || dy+y <0 || dy+y>7){
            return null;
        }
        return ans;
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
