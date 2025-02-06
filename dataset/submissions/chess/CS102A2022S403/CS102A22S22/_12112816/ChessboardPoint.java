import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint (int x, int y){
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
        return "("+x+","+y+")";
    }

    public ChessboardPoint offset(int dx, int dy){
        if (x+dx>=0 & x+dx<=7 & y+dy>=0 & y+dy<=7){
            return new ChessboardPoint(x+dx,y+dy);
        }
        else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }

}
