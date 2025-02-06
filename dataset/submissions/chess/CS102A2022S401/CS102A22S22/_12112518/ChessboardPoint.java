import java.util.Objects;

public class ChessboardPoint {

    private int x;
    private int y;

    public ChessboardPoint(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",this.getX(),this.getY());
    }

    public ChessboardPoint offset(int dx, int dy){
        if (this.x + dx > 7 || this.x + dx < 0 || this.y + dy > 7 || this.y + dy < 0){
            return null;
        }else {
            int a = this.x + dx;
            int b = this.y + dy;

            return new ChessboardPoint(a, b);
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