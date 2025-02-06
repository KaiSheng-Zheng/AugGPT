import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> cMT = new ArrayList();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessColor color = this.getChessColor();
        for (int y1 = y - 1; y1 >= 0; y1--) {
            if (chessboard[x][y1] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x, y1));
            } else if (!chessboard[x][y1].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x, y1));
                break;
            } else {
                break;
            }
        }
        for (int y1 = y + 1; y1 <= 7; y1++) {
            if (chessboard[x][y1] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x, y1));
            } else if (!chessboard[x][y1].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x, y1));
                break;
            } else {
                break;
            }
        }
        for (int x1 = x - 1; x1 >= 0; x1--) {
            if (chessboard[x1][y] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x1, y));
            } else if (!chessboard[x1][y].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x1, y));
                break;
            } else {
                break;
            }
        }
        for (int x1 = x + 1; x1 <= 7; x1++) {
            if (chessboard[x1][y] instanceof EmptySlotComponent) {
                cMT.add(new ChessboardPoint(x1, y));
            } else if (!chessboard[x1][y].getChessColor().equals(color)) {
                cMT.add(new ChessboardPoint(x1, y));
                break;
            } else {
                break;
            }
        }
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
