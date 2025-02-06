import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ConcreteChessGame.canMovetoQueen(x, y, i, j, this) && whichcolor(new ChessboardPoint(i, j)) != getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(i, j));
                }
            }
        }
        return chessboardPoints;
    }
}
