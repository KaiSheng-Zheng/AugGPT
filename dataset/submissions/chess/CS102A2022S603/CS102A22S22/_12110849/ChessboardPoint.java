import java.util.Arrays;
import java.util.Objects;

public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess
    private ChessComponent[][] chessComponents;

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

    public String toString(){
        return "("+getX()+","+getY()+")";
    }
    public ChessboardPoint offset(int dx, int dy){
        int a = this.x + dx;
        int b = this.y + dy;
        if ((a<8&&b<8) && (a>=0&&b>=0)){
            return new ChessboardPoint(a,b);
        }
        else return null;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof ChessboardPoint) {
//            ChessboardPoint chessboardPoint= (ChessboardPoint) obj;
//            if (chessboardPoint.getX() == ((ChessboardPoint) obj).getX()
//                    && chessboardPoint.getY()==((ChessboardPoint) obj).getY())  return true;
//            else return false;
//        }
//      return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y && Arrays.equals(chessComponents, that.chessComponents);
    }
}
