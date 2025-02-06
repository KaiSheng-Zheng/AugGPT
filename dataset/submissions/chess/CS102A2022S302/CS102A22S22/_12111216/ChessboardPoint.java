import java.util.Objects;

public class ChessboardPoint implements Comparable<ChessboardPoint>{
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
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
     * @return
     */
    @Override
    public String toString() {

        return String.format("(%d,%d)",this.x,this.y);
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if(this.x+dx>7||this.x+dy<0||this.y+dy>7||this.y+dy<0){
            return null;
        }
        else {ChessboardPoint p1 = new ChessboardPoint(this.x+dx,this.y+dy);
        return p1;}
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX() == o.getX()) {
            return this.getY() - o.getY();
        }
        return this.getX() - o.getX();
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
}
