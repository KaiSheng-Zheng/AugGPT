import java.util.Objects;

public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x,int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String toString(){
         String result = "(" + x +"," + y +")" ;
         return result;
    }
    public ChessboardPoint offset(int dx, int dy){
        ChessboardPoint chessboardPoint = new ChessboardPoint(x,y);
        chessboardPoint.x += dx;
        chessboardPoint.y += dy;
        if (chessboardPoint.x<8 && chessboardPoint.y<8){
            return chessboardPoint;
        }
        else {
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
