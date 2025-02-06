public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;//row
    private int y;//column

    /**
     * should design
     *
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     *
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
        int x = this.x + dx;
        int y = this.y + dy;
        if (x > -1 && x < 8 && y > -1 && y < 8) {
            return new ChessboardPoint(x, y);
        } else {
            return null;
        }
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(x < o.getX()){
            return -1;
        }else if (x > o.getX()){
            return 1;
        } else {
            if (y <o.getY()){
                return -1;
            }else if (y > o.getY()){
                return 1;
            }
        }
        return 0;
    }
}