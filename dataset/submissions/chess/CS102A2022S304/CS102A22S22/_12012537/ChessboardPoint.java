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
        String a="("+getX()+","+getY()+")";
        return a;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int xx=getX()+dx;
        int yy=getY()+dy;
        if(xx>7||xx<0||yy>7||yy<0){
            return null;
        }
        else{
            return new ChessboardPoint(xx,yy);
        }
    }
}
