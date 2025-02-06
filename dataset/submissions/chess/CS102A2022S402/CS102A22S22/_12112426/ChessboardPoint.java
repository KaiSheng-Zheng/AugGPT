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
        if ((this.x + dx) < 8 && (this.y + dy) < 8 && (this.y + dy) >= 0 && (this.x + dx) >= 0){
            ChessboardPoint newPoint=new ChessboardPoint(this.x+dx,this.y+dy);
            return newPoint;
        }else {return null;}
    }
}

