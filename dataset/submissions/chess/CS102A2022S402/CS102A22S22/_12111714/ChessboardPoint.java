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
        return ("("+x+","+y+")");
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx >= 8 || x + dx < 0 || y + dy >= 8 || y + dy < 0){
            return null;
        }
        else {
            return new ChessboardPoint(x + dx,y + dy);
        }

    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.x < o.x){
            return -1;
        }
        else if(this.x > o.x){
            return 1;
        }
        else return Integer.compare(this.y, o.y);
    }
}
