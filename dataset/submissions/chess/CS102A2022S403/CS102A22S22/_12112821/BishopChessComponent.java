import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> ans = new ArrayList<>();
        ChessComponent[][] chessComponents = getChessComponents();
        for (int i = x + 1, j = y + 1; i <= 7 && j <= 7; i++, j++) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE
                    || chessComponents[i][j].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(i, j));
                if (chessComponents[i][j].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE
                    || chessComponents[i][j].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(i, j));
                if (chessComponents[i][j].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }

        for (int i = x + 1, j = y - 1; i <= 7 && j >= 0; i++, j--) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE
                    || chessComponents[i][j].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(i, j));
                if (chessComponents[i][j].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j <= 7; i--, j++) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE
                    || chessComponents[i][j].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(i, j));
                if (chessComponents[i][j].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        return ans;
    }
}
