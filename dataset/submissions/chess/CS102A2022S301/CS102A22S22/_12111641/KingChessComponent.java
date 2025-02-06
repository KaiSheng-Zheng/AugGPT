import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessboardPoint chessboardPoint1 = new ChessboardPoint(x + 1, y);
        ChessboardPoint chessboardPoint2 = new ChessboardPoint(x - 1, y);
        ChessboardPoint chessboardPoint3 = new ChessboardPoint(x, y + 1);
        ChessboardPoint chessboardPoint4 = new ChessboardPoint(x, y - 1);
        ChessboardPoint chessboardPoint5 = new ChessboardPoint(x + 1, y + 1);
        ChessboardPoint chessboardPoint6 = new ChessboardPoint(x + 1, y - 1);
        ChessboardPoint chessboardPoint7 = new ChessboardPoint(x - 1, y + 1);
        ChessboardPoint chessboardPoint8 = new ChessboardPoint(x - 1, y - 1);

        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        chessboardPoints.add(chessboardPoint1);
        chessboardPoints.add(chessboardPoint2);
        chessboardPoints.add(chessboardPoint3);
        chessboardPoints.add(chessboardPoint4);
        chessboardPoints.add(chessboardPoint5);
        chessboardPoints.add(chessboardPoint6);
        chessboardPoints.add(chessboardPoint7);
        chessboardPoints.add(chessboardPoint8);
        return chessboardPoints;
    }
}
