import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
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

        return x;
    }

    /**
     * should design
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * should design
     */
    @Override
    public String toString() {
        String s = String.format("(%d,%d)",getX(),getY());
        return s;
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

    /**
     * should design
     *
     */
    public ChessboardPoint offset(int dx, int dy) {
        int fx = dx+getX();
        int fy = dy+getY();

        if (fx>=8||fx<0||fy>=8||fy<0){
            return null;
        }
        else {
           ChessboardPoint chess = new ChessboardPoint(fx,fy);
           return chess;
        }
    }
}
