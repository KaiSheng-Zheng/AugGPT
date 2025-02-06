import java.util.Arrays;

public class ChessboardPoint implements Comparable<ChessboardPoint>{
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
        return String.format("(%d,%d)", getX(), getY());
    }


    /**
     * should design
     *
     * @param dx
     * @param dy
     * @return
     */
    public ChessboardPoint offset(int dx, int dy) {
        if (getX() + dx <= 7 && getY() + dy <= 7) {
            return new ChessboardPoint(getX() + dx, getY() + dy);
        }
        else {
            return null;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if (obj  instanceof ChessboardPoint) {
            ChessboardPoint CHESS = (ChessboardPoint) obj;
            return this.x == CHESS.x && this.y == CHESS.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if(this.getX()<o.getX())
            return -1;
        else if(this.getX()>o.getX())
            return 1;
        else{
            if(this.getY()>o.getY())
                return 1;
            else if(this.getY()<o.getY())
                return -1;
            else
                return 0;
        }
    }
}
