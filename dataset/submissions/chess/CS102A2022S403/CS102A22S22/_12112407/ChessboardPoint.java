import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;
    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String toString(){
        return String.format("(%d,%d)",getX(),getY());
    }
    public ChessboardPoint offset(int dx,int dy){
        if (getX()+dx>7||getX()+dx<0||getY()+dy>7||getY()+dy<0){
            return null;
        }
        return new ChessboardPoint(getX()+dx,getY()+dy);
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
