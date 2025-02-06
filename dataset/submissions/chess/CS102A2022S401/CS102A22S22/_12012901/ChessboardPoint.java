import java.util.Objects;

public class ChessboardPoint implements Comparable<ChessboardPoint> {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
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
        ChessboardPoint newChess = new ChessboardPoint(this.x + dx, this.y + dy);
        if (0 <= newChess.getX() && newChess.getX() <= 7 && 0 <= newChess.getY() && newChess.getY() <= 7) {
            return newChess;
        } else {
            return null;
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
    public int compareTo(ChessboardPoint o) {
        if (x > o.getX() || x == o.getX() && y > o.getY())
            return 1;
        if (x == o.getX() && y == o.getY())
            return 0;
        return -1;
    }
}
