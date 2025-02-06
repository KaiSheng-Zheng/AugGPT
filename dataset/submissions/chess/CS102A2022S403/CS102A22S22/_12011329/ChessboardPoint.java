import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ChessboardPoint() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx, int dy) {
        int A=getX()+dx;
        int B=getY()+dy;
        if ((A<0||A>7)||(B<0||B>7)){
            return null;
        }
        return new ChessboardPoint(A,B);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        ChessboardPoint that = (ChessboardPoint)obj;
        return x == that.getX() && y == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}