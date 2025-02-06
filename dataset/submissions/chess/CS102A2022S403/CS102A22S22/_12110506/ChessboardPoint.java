import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x horizontal location of this chess
     * @param y vertical location of this chess
     */
    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * should design
     * @return horizontal location of this chess
     */
    public int getX() {
        return x;
    }

    /**
     * should design
     * @return vertical location of this chess
     */
    public int getY() {
        return y;
    }
    
    /**
     * should design
     * @param o other chess
     * @return whether this chess is the same as other chess
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }
    
    /**
     * should design
     * @return the hash code of this chess
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    /**
     * should design
     * @return the location of this chess
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }


    /**
     * should design
     * @param dx change in horizontal location of this chess
     * @param dy change in vertical location of this chess
     * @return the new location of this chess
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx < 0 || x + dx > 7 || y + dy < 0 || y + dy > 7) {
            return null;
        }
        return new ChessboardPoint(x + dx, y + dy);
    }
}
