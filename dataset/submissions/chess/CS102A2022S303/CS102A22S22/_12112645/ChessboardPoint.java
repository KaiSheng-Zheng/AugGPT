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
        return "("+getX()+","+getY()+")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
       if(getX()+dx>=0&&getX()+dx<=7&&getY()+dy>=0&&getY()+dy<=7){
           ChessboardPoint after=new ChessboardPoint(getX()+dx,getY()+dy);
           return after;
       }else {return null;}

    }

    @Override
    public int compareTo(ChessboardPoint o) {

            if(x>o.getX()){
                return 1;
            }else if (x==o.getX()){
                if (y>o.getY()){
                    return 1;
                }else if(y<o.getY()){
                    return -1;
                }else {return 0;}
            }else {return -1;}

        }
}