public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

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
        if (getX() + dx < 0 || getX() + dx > 7 || getY() + dy < 0 || getY() + dy > 7) {
            return null;
        } else {
            return new ChessboardPoint(getX() + dx, getY() + dy);
        }

    }

    @Override
    public int compareTo(ChessboardPoint o) {
        if (this.getX() < o.getX()) {
            return -1;
        } else if (this.getX() > o.getX()) {
            return 1;
        } else if (this.getY() < o.getY()) {
            return -1;
        } else if (this.getY() > o.getY()) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChessboardPoint) {
            if (this.getX()==((ChessboardPoint) obj).getX() && this.getY()==((ChessboardPoint) obj).getY()){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
