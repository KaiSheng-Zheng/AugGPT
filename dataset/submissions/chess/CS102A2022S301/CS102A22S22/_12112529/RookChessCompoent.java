import java.util.ArrayList;
import java.util.List;

public class RookChessCompoent extends ChessComponent {
    public RookChessCompoent(char X, ChessboardPoint point) {
        super(X, point);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> RooksLand = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (i == X && j != Y){
                    RooksLand.add(new ChessboardPoint(i,j));
                }
                else if (i != X && j == Y){
                    RooksLand.add( new ChessboardPoint(i,j));
                }
            }
        }
        return RooksLand;
    }
}