import java.util.Objects;

public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x; // x: Horizontal location of this chess
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

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
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint result = new ChessboardPoint(x + dx, y + dy);
        if (result.x < 0 || result.x > 7 || result.y < 0 || result.y > 7) {
            return null;
        }
        return result;
    }

    public ChessboardPoint reverse() {
        return new ChessboardPoint(y, x);
    }

    @Override
    public int compareTo(ChessboardPoint another) {
        int dx = x - another.x;
        if (dx != 0) {
            return dx;
        }
        return y - another.y;
    }

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
}