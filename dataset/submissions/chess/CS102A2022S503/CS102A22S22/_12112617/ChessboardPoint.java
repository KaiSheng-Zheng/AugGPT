public class ChessboardPoint implements Comparable {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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
        return "("+x+","+y+")";}


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int Newx = x+dx, Newy = y+dy;
        if (Newx<0||Newy<0||Newx>7||Newy>7){
            return null;
        }else
            return new ChessboardPoint(Newx,Newy);
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
