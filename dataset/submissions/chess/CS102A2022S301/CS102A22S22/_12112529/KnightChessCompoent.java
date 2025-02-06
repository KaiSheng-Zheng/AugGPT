import java.util.ArrayList;
import java.util.List;

public class KnightChessCompoent extends ChessComponent {
    public KnightChessCompoent(char X, ChessboardPoint point) {
        super(X, point);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> KnightsLand = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        for (int i = X-2; i <=X+2; i++) {
            for (int j = Y-2; j <=Y+2; j++) {
                if (j<=7 && j >=0 && Math.abs(Y - j) == 2){
                    if (i <=7 && i >=0 && Math.abs(X - i) == 1){
                        if (i != X && j != Y) {
                            KnightsLand.add(new ChessboardPoint(i, j));
                        }
                    }
                }
                else if (j<=7 && j >=0 && Math.abs(Y - j) == 1){
                    if (i <=7 && i >=0 && Math.abs(X - i) == 2){
                        if (i != X && j != Y) {
                            KnightsLand.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return KnightsLand;
    }
}