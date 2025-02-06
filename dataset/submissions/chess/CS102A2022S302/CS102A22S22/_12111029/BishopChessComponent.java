import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> cMT = new ArrayList();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessColor color = this.getChessColor();
        for (int x1 = x - 1, y1 = y - 1; x1 >= 0 && y1 >= 0; x1--, y1--) {
            if (chessboard[x1][y1] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x1, y1));
            } else if (!chessboard[x1][y1].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x1, y1));
                break;
            } else {
                break;
            }
        }
        for (int x1 = x + 1, y1 = y + 1; x1 <= 7 && y1 <= 7; x1++, y1++) {
            if (chessboard[x1][y1] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x1, y1));
            } else if (!chessboard[x1][y1].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x1, y1));
                break;
            } else {
                break;
            }
        }
        for (int x1 = x + 1, y1 = y - 1; x1 <= 7 && y1 >= 0; x1++, y1--) {
            if (chessboard[x1][y1] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x1, y1));
            } else if (!chessboard[x1][y1].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x1, y1));
                break;
            } else {
                break;
            }
        }
        for (int x1 = x - 1, y1 = y + 1; x1 >= 0 && y1 <= 7; x1--, y1++) {
            if (chessboard[x1][y1] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x1, y1));
            } else if (!chessboard[x1][y1].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x1, y1));
                break;
            } else {
                break;
            }
        }
        return cMT;
    }
}
