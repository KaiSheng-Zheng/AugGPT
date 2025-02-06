import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessboardPoint)) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

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
        return "(" + this.x + "," + this.y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if ((this.x + dx) > 7 || (this.y + dy) > 7 || (this.x + dx) < 0 || (this.y + dy) < 0) {
            return null;
        } else {
            return new ChessboardPoint(this.x + dx, this.y + dy);
        }
    }

    public ChessboardPoint offset() {
        if ((this.x > 7 || this.y > 7 || this.x < 0 || this.y < 0)) {
            return null;
        } else {
            return new ChessboardPoint(this.x, this.y);
        }
    }
}