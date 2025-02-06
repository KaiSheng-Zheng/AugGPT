import java.util.Comparator;

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
    public boolean isTheSameCoordinate(ChessboardPoint other){
        return getX() == other.getX() && getY() == other.getY();
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }
    public static Comparator<ChessboardPoint> xAscending = (o1, o2) -> {
        final int x1 = o1.getX();
        final int x2 = o2.getX();
        return x1 - x2;
    };
    public static Comparator<ChessboardPoint> yAscending = (o1, o2) -> {
        final int x1 = o1.getX();
        final int x2 = o2.getX();
        final int y1 = o1.getY();
        final int y2 = o2.getY();
        return (x2 - x1 != 0) ? 0 : y1-y2;
    };
    public ChessboardPoint offset(int dx, int dy) {
        return (dx+getX()>7||dx+getX()<0||dy+getY()<0||dy+getY()>7)?null:new ChessboardPoint(getX()+dx,getY()+dy);
    }
}
