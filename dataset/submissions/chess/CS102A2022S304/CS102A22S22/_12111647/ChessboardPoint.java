import java.util.Objects;

/**
 * @author root
 * @version 1.0
 */
public class ChessboardPoint implements Comparable<ChessboardPoint> {

    /** Minimum checkerboard subscript */
    private static final Integer MIN_RANGE = 0;
    /** Maximum chessboard subscript */
    private static final Integer MAX_RANGE = 7;

    /** x: Horizontal location of this chess */
    private int x;
    /** y: Vertical location of this chess */
    private int y;

    /**
     * should design
     * @param x x
     * @param y y
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * @return For an instance, if you have a chess at position (4,2), your toString method is supposed to
     * give a string "(4,2)" (without blank space)
     */
    @Override
    public String toString() {
        return "(" +
                x +
                "," +
                y +
                ")";
    }


    /**
     * You are given the coordinate change in x and y directions respectively as dx and dy. What
     * you need to do is Return a new object of ChessboardPoint type to represent the new
     * coordinate after the move.
     * @param dx dx
     * @param dy dy
     * @return If this leads a point out of chessboard, return null.
     */
    public ChessboardPoint offset(int dx, int dy) {
        return isRangeBeyond(dx, dy) ? null : new ChessboardPoint(dx, dy);
    }

    /**
     *
     * @param dx Move the x
     * @param dy Move the y
     * @return true if the moved coordinates are out of range, false otherwise
     */
    private boolean isRangeBeyond(int dx, int dy) {
        return dx < MIN_RANGE || dx > MAX_RANGE || dy < MIN_RANGE || dy > MAX_RANGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (o.getX() - this.getX() != 0) {
            return this.getX() - o.getX();
        }
        return this.getY() - o.getY();
    }


}
