public class ChessboardPoint implements Comparable {
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
    public ChessboardPoint(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx > 7 || x + dx < 0 || y + dy > 7 || y + dy < 0)
            return null;

        return new ChessboardPoint(x + dx, y + dy);
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    public int compareTo(Object o) {
        if (o instanceof ChessboardPoint) {
            ChessboardPoint chessboardPoint = (ChessboardPoint) o;
            int diffX = x - chessboardPoint.getX(), diffY = y - chessboardPoint.getY();
            if (diffX > 0) {
                return 1;
            } else if (diffX == 0) {
                if (diffY > 0) {
                    return 1;
                } else if (diffY == 0) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

        return 0;
    }
}
