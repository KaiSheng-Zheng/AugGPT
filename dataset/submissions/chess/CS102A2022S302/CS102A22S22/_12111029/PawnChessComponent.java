import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> cMT = new ArrayList();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getChessColor().equals(ChessColor.BLACK)) {
            if (x + 1 <= 7 && chessboard[x + 1][y] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x + 1, y));
                if (x == 1 && chessboard[x + 2][y] instanceof EmptySlotComponent) {
                    cMT.add(new ChessboardPoint(x + 2, y));
                }
            }
            if (x + 1 <= 7 && y + 1 <= 7
                    && chessboard[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                cMT.add(new ChessboardPoint(x + 1, y + 1));
            }
            if (x + 1 <= 7 && y - 1 >= 0
                    && chessboard[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                cMT.add(new ChessboardPoint(x + 1, y - 1));
            }
        } else if (this.getChessColor().equals(ChessColor.WHITE)) {
            if (x - 1 >= 0 && chessboard[x - 1][y] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x - 1, y));
                if (x == 6 && chessboard[x - 2][y] instanceof EmptySlotComponent) {
                    cMT.add(new ChessboardPoint(x - 2, y));
                }
            }
            if (x - 1 >= 0 && y + 1 <= 7
                    && chessboard[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                cMT.add(new ChessboardPoint(x - 1, y + 1));
            }
            if (x - 1 >= 0 && y - 1 >= 0
                    && chessboard[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                cMT.add(new ChessboardPoint(x - 1, y - 1));
            }
        }
        return cMT;
    }
}
