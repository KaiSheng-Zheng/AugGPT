import java.util.Objects;

public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

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
        if (getX() + dx > 7 || getY() + dy > 7 || getX() + dx < 0 || getY() + dy < 0) {
            return null;
        } else {
            ChessboardPoint chessboardPoint = new ChessboardPoint(getX() + dx, getY() + dy);
            return chessboardPoint;
        }

    }

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

    @Override
    public int compareTo(ChessboardPoint o) {
        if (x < o.getX()) {
            return -1;
        } else if (x == o.getX()) {
            if (y < o.getY()) return -1;
            else return 1;
        } else {
            return 1;
        }
    }
}
