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
        return "("+getX()+","+getY()+")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if(dx+getX()<=7&&dy+getY()<=7&&dx+getX()>=0&&dy+getY()>=0){
            ChessboardPoint afterMove = new ChessboardPoint(dx+this.getX(),dy+this.getY());
            return afterMove;
        }
        else return null;
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
