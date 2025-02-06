public class ChessboardPoint {
    private int x;
    private int y;


    /**
     * should design
     * @param x
     * @param y
//     * @param dx
//     * @param dy
     */
    public ChessboardPoint(int x, int y) {
        if (x>=0&&x<=7&&y>=0&&y<=7) {
            this.x = x;
            this.y = y;

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
        int a= x +dx;
        int b= y +dy;
        if (a>=0&&a<=7&&b>=0&&b<=7){
           ChessboardPoint index = new ChessboardPoint(a,b);
        return index;
        }
        else {return null;}
    }
}
