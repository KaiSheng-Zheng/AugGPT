public class ChessboardPoint implements Comparable<ChessboardPoint> {
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
        int a = getX();
        int b = getY();
        return "("+a+","+b+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */

    public ChessboardPoint offset(int dx, int dy) {
        if(checkSetX(dx) && checkSetY(dy)){
            int x = getX()+dx;
            int y = getY()+dy;
            return new ChessboardPoint(x,y);
        }else{
            return null;
        }
    }

    public boolean checkSetX(int dx){
        int x = getX();
        if(x+dx<=7 && x+dx>=0){
            return true ;
        }else{
            return false;
        }
    }

    public boolean checkSetY(int dy){
        int y = getY();
        if(y+dy<=7 && y+dy>=0){
            return true ;
        }else{
            return false;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        return 0;
    }
}
