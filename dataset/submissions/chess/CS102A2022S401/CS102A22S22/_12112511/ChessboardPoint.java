import java.util.Objects;

public class ChessboardPoint {
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
    public int getX() {return x;}

    /**
     * should design
     * @return
     */
    public int getY() {return y;}

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(getX()).append(',').append(getY()).append(')');
        return sb.toString();
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        int targetX = this.x + dx;
        int targetY = this.y + dy;
        if (targetX > 7 | targetX < 0){return null;}
        if (targetY > 7 | targetY < 0){return null;}
        return new ChessboardPoint(targetX,targetY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }
}
