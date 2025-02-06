public class ChessboardPoint {
    private int x;
    private int y;

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
        return String.format("(%d,%d)", getX(), getY());
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx >= 0
                && x + dx < 8
                && y + dy >= 0
                && y + dy < 8)
            return new ChessboardPoint(x + dx, y + dy);
        else
            return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessboardPoint)) return false;

        ChessboardPoint that = (ChessboardPoint) o;

        if (getX() != that.getX()) return false;
        return getY() == that.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        result = 31 * result + getY();
        return result;
    }
}
