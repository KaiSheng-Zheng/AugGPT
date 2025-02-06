import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {



    public RookChessComponent() {

    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> rook = new ArrayList<>();
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
                rook.add(new ChessboardPoint(i, y));
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
                rook.add(new ChessboardPoint(i, y));
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
                rook.add(new ChessboardPoint(x, i));
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
                rook.add(new ChessboardPoint(x, i));
            }
        }
//        for (int i = 0; i < rook.size(); i++) {
//            System.out.println(rook.get(i));
//        }
        return rook;
    }

}
