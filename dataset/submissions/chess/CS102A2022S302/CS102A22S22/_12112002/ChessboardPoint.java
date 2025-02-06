public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
        String str;
        str="("+this.x+","+this.y+")";
        return str;
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (this.x+dx>7||this.x+dx<0||this.y+dy>7||this.y+dy<0){
            return null;
        }

        ChessboardPoint chessboardPoint=new ChessboardPoint(this.x+dx,this.y+dy);
        return chessboardPoint;

    }
    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.x==o.getX()){
            if (this.y>o.getY()){
                return 1;
            }else if (this.y==o.getY()){

                    return 0;

            }else {
                return -1;
            }
        }else if (this.x>o.getX()){
            return 1;
        }
        else {
            return -1;
        }
    }
}
