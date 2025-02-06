import java.util.Objects;
public class ChessboardPoint {
    private int x;
    private int y;
    public int hashCode() {
        return Objects.hash(x, y);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public String toString() {
        return "(" +x + "," + y + ")";
    }

    public ChessboardPoint(int x, int y) {
        this.x =x;
        this.y =y;}
    @Override
    public boolean equals(Object object) {
        if (this==object) return true;
        if (object ==null || getClass() != object.getClass()) return false;
        ChessboardPoint chess1 = (ChessboardPoint) object;
        return y == chess1.y&& x == chess1.x;
    }

}
