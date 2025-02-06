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
        return "(" +x + "," + y + ")";
    }



    public ChessboardPoint offset(int dx, int dy) {
        int a = x+dx;
        int b = y+dy;
        if (a>=0 && a<=7 && b>=0 && b<=7){
            ChessboardPoint c = new ChessboardPoint(a,b);
            return c;
        }else {
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
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
