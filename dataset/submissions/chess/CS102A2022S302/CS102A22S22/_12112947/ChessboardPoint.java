
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
        return this.x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return this.y;
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
        ChessboardPoint chessboardPoint = new ChessboardPoint(this.x+dx,this.y+dy);
        if(this.x+dx>7||this.x+dx<0||this.y+dy>7||this.y+dy<0){
            return null;
        }else {
            return chessboardPoint;
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
        ChessboardPoint p=(ChessboardPoint)o;
        return x==p.x&&y==p.y;
    }

}
