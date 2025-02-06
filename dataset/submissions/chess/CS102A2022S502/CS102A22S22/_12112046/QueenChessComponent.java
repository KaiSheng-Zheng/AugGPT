import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{



    public QueenChessComponent(){

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> queen = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        boolean can;
        for (int i = x + 1; i < 8; i++) {
            can = true;
            for (int j = x + 1; j < i; j++) {
                if (chessboard[j][y].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][y].getChessColor() != getChessColor()) {
                queen.add(new ChessboardPoint(i, y));
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            can = true;
            for (int j = x - 1; j > i; j--) {
                if (chessboard[j][y].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][y].getChessColor() != getChessColor()) {
                queen.add(new ChessboardPoint(i, y));
            }
        }
        for (int i = y + 1; i < 8; i++) {
            can = true;
            for (int j = y + 1; j < i; j++) {
                if (chessboard[x][j].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[x][i].getChessColor() != getChessColor()) {
                queen.add(new ChessboardPoint(x, i));
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            can = true;
            for (int j = y - 1; j > i; j--) {
                if (chessboard[x][j].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[x][i].getChessColor() != getChessColor()) {
                queen.add(new ChessboardPoint(x, i));
            }
        }
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            can = true;
            for (int k = x + 1, l = y + 1; k < i && l < j; k++, l++) {
                if (chessboard[k][l].getChessColor() != ChessColor.NONE) {
                    can = false;
                    break;
                }
            }
            if (can && chessboard[i][j].getChessColor() != getChessColor()) {
                queen.add(new ChessboardPoint(i, j));
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
                queen.add(new ChessboardPoint(i, j));
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
                queen.add(new ChessboardPoint(i, j));
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
                queen.add(new ChessboardPoint(i, j));
            }
        }
//        for (ChessboardPoint chessboardPoint : queen) {
//            System.out.println(chessboardPoint);
//        }
        return queen;
    }

}
