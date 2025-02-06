

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
       return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * should design
     * @return
     */
    public int getY() {

        return this.y;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }
    @Override
        public int compareTo(ChessboardPoint chessboardPoint) {
        if (this.getX() > chessboardPoint.getX()) {
            return 1;
        } else if (this.getX() < chessboardPoint.getX()) {
            return -1;
        } else if (this.getY() > chessboardPoint.getY()) {
            return 1;
        } else if (this.getY() < chessboardPoint.getY()) {
            return -1;
        }
return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint chess = (ChessboardPoint) o;
        if (x != chess.x) return false;
        if (y != chess.y) return false;
        return true;
    }

    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
         if (getX()+dx>=8||getX()+dx<0||getY()+dy>=8||getY()+dy<0){
             return  null;
         }else {
//             setX(getX()+dx);
//             setY(getY()+dy);
             return new ChessboardPoint(getX()+dx,getY()+dy);
         }
    }
}
