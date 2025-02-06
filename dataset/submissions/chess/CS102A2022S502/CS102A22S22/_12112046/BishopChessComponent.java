
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent() {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> bishop = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        boolean can;
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            can = true;
            for (int k = x + 1, l = y + 1; k < i && l < j; k++, l++) {
                if (chessboard[k][l].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][j].getChessColor() != getChessColor()) {
                bishop.add(new ChessboardPoint(i, j));
            }
        }
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            can = true;
            for (int k = x + 1, l = y - 1; k < i && l > j; k++, l--) {
                if (chessboard[k][l].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][j].getChessColor() != getChessColor()) {
                bishop.add(new ChessboardPoint(i, j));
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            can = true;
            for (int k = x - 1, l = y + 1; k > i && l < j; k--, l++) {
                if (chessboard[k][l].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][j].getChessColor() != getChessColor()) {
                bishop.add(new ChessboardPoint(i, j));
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            can = true;
            for (int k = x - 1, l = y - 1; k > i && l > j; k--, l--) {
                if (chessboard[k][l].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][j].getChessColor() != getChessColor()) {
                bishop.add(new ChessboardPoint(i, j));
            }
        }
//        for (int i = 0; i < bishop.size(); i++) {
//            System.out.println(bishop.get(i));
//        }
        return bishop;
    }


}
