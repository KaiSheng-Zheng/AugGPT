import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();

        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int i = 0, j = 0;
        while (i < 8 || i != x) {
            ChessboardPoint chessboardPoint = new ChessboardPoint(x, i);
            chessboardPoints.add(chessboardPoint);
            i++;
        }
        while (j < 8 || j != y) {
            ChessboardPoint chessboardPoint = new ChessboardPoint(j, y);
            chessboardPoints.add(chessboardPoint);
            j++;
        }
        int m = x - y;
        if (m == 0) {
            for (int k = 0; k < 7 && k != x; k++) {



            }
        }


        return chessboardPoints;
    }
}
