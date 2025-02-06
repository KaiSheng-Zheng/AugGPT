import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char X, ChessboardPoint point) {
        super(X, point);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> KingsLand = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        for (int i = X-1; i <=X+1; i++) {
            for (int j = Y-1; j <=Y+1; j++) {
                if (j<=7 && j >=0){
                    if (i <=7 && i >=0){
                        if (i != X && j != Y) {
                            KingsLand.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return KingsLand;
    }
}