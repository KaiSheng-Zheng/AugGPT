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
        String result="(" + x + "," + y + ")";
        return result;
    }


    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint result=new ChessboardPoint(dx+x,dy+y);
        if(result.getX()>=0&&result.getX()<=7&&result.getY()>=0&&result.getY()<=7){
            return result;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessboardPoint)) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return getX() == that.getX() && getY() == that.getY();
    }

}
