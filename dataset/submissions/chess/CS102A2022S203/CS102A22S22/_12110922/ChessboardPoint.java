public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

    /**
     * Creates a new ChessboardPoint.
     * 
     * @param x
     * @param y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x of point.
     * 
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Get y of point.
     * 
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Return the string representation of this object.
     * 
     * @return string of this object
     */
    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    /**
     * Get the moved point with the given offset.
     *
     * @param dx x offset
     * @param dy y offset
     * @return moved point
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx < 0) {
            return null;
        }
        if (x + dx >= 8) {
            return null;
        }
        if (y + dy < 0) {
            return null;
        }
        if (y + dy >= 8) {
            return null;
        }
        return new ChessboardPoint(x + dx, y + dy);
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (x == o.x) {
            return Integer.compare(y, o.y);
        } else {
            return Integer.compare(x, o.x);
        }
    }
}