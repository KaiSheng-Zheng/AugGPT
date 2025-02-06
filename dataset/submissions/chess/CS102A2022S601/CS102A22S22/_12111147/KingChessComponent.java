import java.util.ArrayList;
//import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(int x, int y, char name) {
        super(x, y, name);
    }
    public KingChessComponent(){}
    List<ChessboardPoint> l1 = new ArrayList<>();
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l1 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == getX() && j == getY()){
                    continue;
                }
                else if((Math.abs(i-getX()) <= 1 && Math.abs(j-getY()) <= 1) && !(chessboard[i][j].getChessColor().equals(this.getChessColor()))){
                    l1.add(new ChessboardPoint(i,j));
                }
            }
        }
        return l1;
    }
}