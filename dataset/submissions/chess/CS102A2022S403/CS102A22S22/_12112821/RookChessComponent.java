import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = getSource().getX();
        int y = getSource().getY();
        ChessComponent[][] chessComponents = getChessComponents();
        List<ChessboardPoint> ans = new ArrayList<>();

        for (int i = x - 1; i >= 0; i--) {
            if (chessComponents[i][y].getChessColor() == ChessColor.NONE
                    || chessComponents[i][y].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(i,y));
                if (chessComponents[i][y].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        for (int i = x + 1; i <= 7 ; i++) {
            if (chessComponents[i][y].getChessColor() == ChessColor.NONE
                    || chessComponents[i][y].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(i,y));
                if (chessComponents[i][y].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (chessComponents[x][i].getChessColor() == ChessColor.NONE
                    || chessComponents[x][i].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(x,i));
                if (chessComponents[x][i].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        for (int i = y + 1; i <= 7 ; i++) {
            if (chessComponents[x][i].getChessColor() == ChessColor.NONE
                    || chessComponents[x][i].getChessColor() != getChessColor()) {
                ans.add(new ChessboardPoint(x,i));
                if (chessComponents[x][i].getChessColor() != ChessColor.NONE) break;
            } else {
                break;
            }
        }
        return ans;
    }
}
