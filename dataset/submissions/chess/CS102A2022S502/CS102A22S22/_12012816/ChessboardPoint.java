public class ChessboardPoint implements Comparable{
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
        int newx = dx+x,newy = dy+y;
        if (newx<0||newy<0||newx>7||newy>7){
            return null;
        }else
            return new ChessboardPoint(newx,newy);
    }
    public static ChessboardPoint creatPoint(int x,int y){
        int newx = x,newy = y;
        if (newx<0||newy<0||newx>7||newy>7){
            return null;
        }else
            return new ChessboardPoint(newx,newy);
    }

    @Override
    public int compareTo(Object o) {
        if (this.x<((ChessboardPoint)o).x)
            return -1;
        else if (this.x>((ChessboardPoint)o).x)
            return 1;
        else {
            if (this.y<((ChessboardPoint)o).y)
                return -1;
            else if (this.y>((ChessboardPoint)o).y)
                return 1;
            else return 0;
        }
    }
}
