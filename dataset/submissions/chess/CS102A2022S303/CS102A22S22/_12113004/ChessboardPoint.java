public class ChessboardPoint {
    private int x;
    // x: Horizontal location of this chess
    private int y;
    // y: Vertical location of this chess

    /**
     * constructor
     * @param x Horizontal
     * @param y Vertical
     * x\y 0 1 2 3 4 5 6 7
     *  0  R N B Q K B N R
     *  1  P P P P P P P P
     *  2  _ _ _ _ _ _ _ _
     *  3  _ _ _ _ _ _ _ _
     *  4  _ _ _ _ _ _ _ _
     *  5  _ _ _ _ _ _ _ _
     *  6  p p p p p p p p
     *  7  r n b q k b n r
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",getX(),getY());
    }


    /**
     * the change in x and y directions respectively as dx and dy
     * @param dx the change of x in movement
     * @param dy the change of y in movement
     * @return a new object of ChessboardPoint type to represent the new coordinate after the move
     *         If this leads a point out of chessboard, return null.
     */
    public ChessboardPoint offset(int dx, int dy) {
        boolean a = 0<=(dx+getX()) && (dx+getX())<=7;
        boolean b = 0<=(dy+getY()) && (dy+getY())<=7;
        if (a && b){
            return new ChessboardPoint(dx+getX(),dy+getY());
        }else return null;
    }

    public boolean canMove(int dx, int dy) {
        boolean a = 0<=(dx+getX()) && (dx+getX())<=7;
        boolean b = 0<=(dy+getY()) && (dy+getY())<=7;
        return a && b;
    }
}
