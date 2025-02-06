import java.util.ArrayList;
import java.util.List;

public class QueeenChessCompoent extends ChessComponent {
    public QueeenChessCompoent(char X, ChessboardPoint point) {
        super(X, point);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> QueensLand = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (i == X && j != Y){
                    QueensLand.add(new ChessboardPoint(i,j));
                }
                else if (i != X && j == Y){
                    QueensLand.add( new ChessboardPoint(i,j));
                }
                else if (Math.abs(X - i) == Math.abs((Y - j))){
                    QueensLand.add(new ChessboardPoint(i,j));
                }
            }
        }
        return QueensLand;    }
}