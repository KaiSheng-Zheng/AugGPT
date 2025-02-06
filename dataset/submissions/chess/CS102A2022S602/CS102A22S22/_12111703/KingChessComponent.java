import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(){}
     public  List<ChessboardPoint>  canMoveTo () {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> c = new ArrayList<>();
        if (x - 1 >= 0 && x + 1 <= 7) {
            if (y - 1 >= 0 && y + 1 <= 7) {
                c.add(new ChessboardPoint(x - 1, y - 1));
                c.add(new ChessboardPoint(x - 1, y));
                c.add(new ChessboardPoint(x - 1, y + 1));
                c.add(new ChessboardPoint(x, y - 1));
                c.add(new ChessboardPoint(x, y + 1));
                c.add(new ChessboardPoint(x + 1, y - 1));
                c.add(new ChessboardPoint(x + 1, y));
                c.add(new ChessboardPoint(x + 1, y + 1));
            } else if (y == 0) {
                c.add(new ChessboardPoint(x - 1, y));
                c.add(new ChessboardPoint(x - 1, y + 1));
                c.add(new ChessboardPoint(x, y + 1));
                c.add(new ChessboardPoint(x + 1, y));
                c.add(new ChessboardPoint(x + 1, y + 1));
            }else if (y==7){
                c.add(new ChessboardPoint(x - 1, y - 1));
                c.add(new ChessboardPoint(x - 1, y));
                c.add(new ChessboardPoint(x, y - 1));
                c.add(new ChessboardPoint(x + 1, y - 1));
                c.add(new ChessboardPoint(x + 1, y));
            }
        }else if (x==0){
            if (y - 1 >= 0 && y + 1 <= 7) {

                c.add(new ChessboardPoint(x, y - 1));
                c.add(new ChessboardPoint(x, y + 1));
                c.add(new ChessboardPoint(x + 1, y - 1));
                c.add(new ChessboardPoint(x + 1, y));
                c.add(new ChessboardPoint(x + 1, y + 1));
            } else if (y == 0) {

                c.add(new ChessboardPoint(x, y + 1));
                c.add(new ChessboardPoint(x + 1, y));
                c.add(new ChessboardPoint(x + 1, y + 1));
            }else if (y==7){

                c.add(new ChessboardPoint(x, y - 1));
                c.add(new ChessboardPoint(x + 1, y - 1));
                c.add(new ChessboardPoint(x + 1, y));
            }
        }else if (x==7){
            if (y - 1 >= 0 && y + 1 <= 7) {
                c.add(new ChessboardPoint(x - 1, y - 1));
                c.add(new ChessboardPoint(x - 1, y));
                c.add(new ChessboardPoint(x - 1, y + 1));
                c.add(new ChessboardPoint(x, y - 1));
                c.add(new ChessboardPoint(x, y + 1));
            } else if (y == 0) {
                c.add(new ChessboardPoint(x - 1, y));
                c.add(new ChessboardPoint(x - 1, y + 1));
                c.add(new ChessboardPoint(x, y + 1));
            }else if (y==7){
                c.add(new ChessboardPoint(x - 1, y - 1));
                c.add(new ChessboardPoint(x - 1, y));
                c.add(new ChessboardPoint(x, y - 1));
            }
        }

        return c;
    }
}
