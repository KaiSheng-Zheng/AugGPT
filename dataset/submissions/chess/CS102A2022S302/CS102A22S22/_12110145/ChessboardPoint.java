public class ChessboardPoint {
    private int x;// x: Horizontal location of this chess
    private int y;// y: Vertical location of this chess
/*
For an example, look at the chessboard below
(Just an example for better understanding, not input format)
x\y 0 1 2 3 4 5 6 7
0 R N B Q K B N R
1 P P P P P P P P
2 _ _ _ _ _ _ _ _
3 _ _ _ _ _ _ _ _
4 _ _ _ _ _ _ _ _
5 _ _ _ _ _ _ _ _
6 p p p p p p p p
7 r n b q k b n r
*/

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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
        return "(" + x + "," + y + ")";
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int xMove;  int yMove;
        xMove = x + dx;
       yMove = y + dy;
        if (xMove <= 7 && xMove >= 0 && yMove >= 0 && yMove <= 7) {
            return new ChessboardPoint(xMove, yMove);
        }
        return null;
    }
}
