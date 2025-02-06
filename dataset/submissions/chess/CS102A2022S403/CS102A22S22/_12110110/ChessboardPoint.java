public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
    /*
    For an example, look at the chessboard below
    (Just an example for better understanding, not input format)
    x\y 0 1 2 3 4 5 6 7
    0  R N B Q K B N R
    1  P P P P P P P P
    2  _ _ _ _ _ _ _ _
    3  _ _ _ _ _ _ _ _
    4  _ _ _ _ _ _ _ _
    5  _ _ _ _ _ _ _ _
    6  p p p p p p p p
    7  r n b q k b n r
    */

    /**
     * should design
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = (0 <= x && x <= 7) ? x : 0;
        this.y = (0 <= y && y <= 7) ? y : 0;
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
        return String.format("(%d,%d)", getX(), getY());
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int X = this.x + dx;
        int Y = this.y + dy;
        if (X < 0 || X > 7) {
            return null;
        }
        if (Y < 0 || Y > 7) {
            return null;
        }
        return new ChessboardPoint(X, Y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.getX() < o.getX()){
            return -1;
        }else if (this.getX() == o.getX()){
            if (this.getY() < o.getY()){
                return -1;
            }else if (this.getY() > o.getY()){
                return 1;
            }
        }else if (this.getX() > o.getX()){
            return 1;
        }
        return 0;
    }

}
