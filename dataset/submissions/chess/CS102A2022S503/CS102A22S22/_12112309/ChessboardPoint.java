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
        return "("+x + ","+y+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx,int dy){
        if(x+dx>7||x+dx<0||y+dy>7||y+dy<0){
            return null;
        }
        else{
            int a=x;
            int b=y;
            a=x+dx;
            b=y+dy;
            ChessboardPoint chessboardPoint=new ChessboardPoint(a,b);
            return chessboardPoint;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof ChessboardPoint) {
            ChessboardPoint per = (ChessboardPoint) obj;
            if (this.getX()==(per.getX()) && this.getY() == (per.getY())) {
                return true;
            }
        }
        return false;
    }
}
