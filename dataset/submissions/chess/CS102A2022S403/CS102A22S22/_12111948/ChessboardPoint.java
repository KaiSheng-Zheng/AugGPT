import java.util.Objects;

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
        return String.format("(%d,%d)",x,y);
    }

    public boolean isValidX(int dx){
        if(x + dx >=0 && x + dx <= 7)
            return true;
        return false;
    }

    public boolean isValidY(int dy){
        if(y + dy >= 0 && y + dy <= 7)
            return true;
        return false;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public ChessboardPoint offset(int dx, int dy) {
        if(isValidX(dx) && isValidY(dy)){
            return new ChessboardPoint(x + dx,y + dy);
        }
        return null;
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
